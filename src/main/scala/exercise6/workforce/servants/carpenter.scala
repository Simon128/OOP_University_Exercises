package exercise6.workforce.servants

import exercise6.workforce.equipment._

class Carpenter(override val name: String) extends Worker(name){
    override def canWork(): Boolean = getTool().isInstanceOf[Saw]
    override def toString(): String = s"$name (trained Carpenter) equipped with ${getToolName()}"
}