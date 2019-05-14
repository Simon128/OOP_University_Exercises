package exercise6.workforce.servants

import exercise6.workforce.equipment._

class Miner extends Worker{
    override def canWork(): Boolean = getTool().isInstanceOf[PickAxe]
    override def toString(): String = s"$name (trained Miner) equipped with ${getToolName()}"
}