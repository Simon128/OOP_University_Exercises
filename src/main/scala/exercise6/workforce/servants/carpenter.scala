package exercise6.workforce.servants

import exercise6.workforce.equipment._

class Carpenter extends Worker{
    override def canWork(): Boolean = getTool().isInstanceOf[Saw]
    override def toString(): String = s"$name (trained Carpenter) equipped with ${getToolName()}"
}