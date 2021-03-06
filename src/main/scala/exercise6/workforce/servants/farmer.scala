package exercise6.workforce.servants

import exercise6.workforce.equipment._

class Farmer(override val name: String) extends Worker(name){
    override def canWork(): Boolean = getTool().isInstanceOf[Scythe]
    override def toString(): String = s"$name (trained Farmer) equipped with ${getToolName()}"
}