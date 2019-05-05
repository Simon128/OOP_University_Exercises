package exercise3.graph

import exercise3.flexibels._
import scala.collection.mutable.ListBuffer
import java.util.UUID

class Graph(var startingNode: Node){

    def this(){
        this(null)
        val nodeA = new Node("A", new VariableArray())
        val nodeB = new Node("B", new VariableArray())
        val nodeC = new Node("C", new VariableArray())
        val nodeD = new Node("D", new VariableArray())
        val nodeE = new Node("E", new VariableArray())

        nodeA.getEdges().add(new Edge(nodeB, 2))
        nodeA.getEdges().add(new Edge(nodeD, 4))
        nodeB.getEdges().add(new Edge(nodeA, 2))
        nodeB.getEdges().add(new Edge(nodeC, 2))
        nodeB.getEdges().add(new Edge(nodeE, 4))
        nodeC.getEdges().add(new Edge(nodeB, 2))
        nodeD.getEdges().add(new Edge(nodeA, 4))
        nodeD.getEdges().add(new Edge(nodeE, 2))
        nodeE.getEdges().add(new Edge(nodeB, 4))
        nodeE.getEdges().add(new Edge(nodeD, 2))
        startingNode = nodeA
    }

    def searchDeepAll(): ListBuffer[Node] = {
        val visitedIds = new ListBuffer[UUID]()
        val result = new ListBuffer[Node]()
        
        def nextReachableNode(node: Node): Node = {
            var candidates = new ListBuffer[Edge]()
            for(i <- 0 until node.getEdges().size()){
                if(!visitedIds.contains(node.getEdges().get(i).asInstanceOf[Edge].getTarget().getId())) 
                    candidates += node.getEdges().get(i).asInstanceOf[Edge]
            }
            if(candidates.size == 0) return null
            return candidates.minBy((e: Edge) => e.getLength()).getTarget()
        }

        def inner(currentNode: Node){
            if(!visitedIds.contains(currentNode.getId())){
                result += currentNode
                visitedIds += currentNode.getId()
            }
            var next = nextReachableNode(currentNode)
            while(next != null){
                inner(next)
                next = nextReachableNode(currentNode)
            }
        }
        inner(startingNode)
        return result
    }

    def searchBreadthAll(): ListBuffer[Node] = {
        val visitedIds = new ListBuffer[UUID]()
        val result = new ListBuffer[Node]()

        def getReachableNodes(node: Node): ListBuffer[Node] = {
            val reachable = new ListBuffer[Node]()
            for(i <- 0 until node.getEdges().size()){
                if(!visitedIds.contains(node.getEdges().get(i).asInstanceOf[Edge].getTarget().getId())) 
                    reachable += node.getEdges().get(i).asInstanceOf[Edge].getTarget()
            }
            return reachable
        }
        def inner(currentNodes: ListBuffer[Node]){
            var reachableNodes = new ListBuffer[Node]()

            for(n <- currentNodes){
                visitedIds += n.getId()
                result += n
            }
            for(n <- currentNodes){
                var notExisting = getReachableNodes(n).filter(x => !reachableNodes.exists(rn => rn.getId() == x.getId()))
                reachableNodes ++= notExisting
            }
            if(reachableNodes.size > 0)
                inner(reachableNodes)
        }
        var starter = new ListBuffer[Node]()
        starter += startingNode
        inner(starter)
        return result
    }
}