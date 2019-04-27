package exercise3.graph

class Edge(private val target: Node, private val length: Int){

    def getTarget(): Node = target
    def getLength(): Int = length

    override def toString(): String = {
        return "-" + length + "-(" + target.getName() + ")"
    }
}