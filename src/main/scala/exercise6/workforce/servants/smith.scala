package exercise6.workforce.servants

import exercise6.workforce.equipment._

class Smith(override val name: String) extends Worker(name){
    override def canWork(): Boolean = getTool().isInstanceOf[Hammer]
    override def toString(): String = s"$name (trained Smith) equipped with ${getToolName()}"
}