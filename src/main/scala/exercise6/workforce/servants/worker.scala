package exercise6.workforce.servants

import exercise6.workforce.equipment._

abstract class Worker(val name: String){
    private var tool: Tool = null

    protected def getToolName(): String = {
        if(tool == null)
            return "nothing"
        else 
            return tool.toString()
    }

    def getTool(): Tool = tool
    def canWork(): Boolean = false
    def receiveTool(t: Tool): Unit = tool = t
}