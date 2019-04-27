package exercise3.graph

import exercise3.flexibels._
import java.util.UUID

class Node(private val name: String, private val edges: VariableStructure){

    private val id = UUID.randomUUID()

    def getName(): String = name
    def getEdges(): VariableStructure = edges
    def getId(): UUID = id

    override def toString(): String = {
        var result = name + ":["
        var first = true

        for(i <- 0 until edges.size()){
            if(i != 0) result += " / "
            result += edges.get(i).toString()
        }
        return result + "]"
    }
}