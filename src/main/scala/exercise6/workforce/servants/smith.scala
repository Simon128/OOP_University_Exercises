package exercise6.workforce.servants

import exercise6.workforce.equipment._

class Smith extends Worker{
    override def canWork(): Boolean = getTool().isInstanceOf[Hammer]
    override def toString(): String = s"$name (trained Smith) equipped with ${getToolName()}"
}