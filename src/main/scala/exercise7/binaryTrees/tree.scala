package exercise7.binaryTrees

class Tree[E](val elem: E, val left: Tree[E], val right: Tree[E])
    extends Iterable[E]{
        override def toString = s"$elem( $left, $right )"
        override def iterator: Iterator[E] = new PreOrderIterator[E](this)
    }