package exercise7.binaryTrees

import scala.collection.mutable.ListBuffer

class PreOrderIterator[E](root: Tree[E]) extends Iterator[E] {
    require(root != null)  
    private var path = ListBuffer(root) 
    private var current = root  
    
    private def goNext(): Unit = {
        for(el <- path.reverse){
            current = el
            if(leftSide()) return
            if(rightSide()) return
        }
        current = null
    }

    private def leftSide(): Boolean = {
        if(hasLeft(current)){
            current = current.left
            path += current
            return true
        }
        return false
    }

    private def rightSide(): Boolean = {
        if(hasRight(current)){
            current = current.right
            path += current
            return true
        }
        return false
    }  

    def hasLeft(t: Tree[E]): Boolean = {
        return t.left != null && !path.contains(t.left)
    }
    def hasRight(t: Tree[E]): Boolean = {
        return t.right != null && !path.contains(t.right)
    }

    override def hasNext: Boolean = current != null

    override def next(): E = {    
        if (current == null) 
            throw new NoSuchElementException()
        val result = current.elem
        goNext()
        return result
    } 
} 