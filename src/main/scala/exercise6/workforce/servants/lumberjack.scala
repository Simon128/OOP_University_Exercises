package exercise6.workforce.servants

import exercise6.workforce.equipment._

class Lumberjack(override val name: String) extends Worker(name){
    override def canWork(): Boolean = getTool().isInstanceOf[Axe]
    override def toString(): String = s"$name (trained Lumberjack) equipped with ${getToolName()}"
}