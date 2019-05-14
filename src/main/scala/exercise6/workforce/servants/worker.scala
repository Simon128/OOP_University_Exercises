package exercise6.workforce.servants

import exercise6.workforce.equipment._

class Worker{
    private var tool: Tool = null
    var name: String = "Generic Worker"

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