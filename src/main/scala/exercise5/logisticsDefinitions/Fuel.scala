package exercise5.logisticsDefinitions

import exercise5.logisticsEntities.Metric._
import exercise5.logisticsEntities.FuelName._

trait Fuel{
    private var amount: Int = 0
    val maximum: Int
    val name: FuelName
    val metric: Metric

    def getAmount(): Int = amount
    protected def setAmount(a: Int): Unit ={
        require(a > 0 && a <= maximum, "err")
        amount = a
    }
    def resetAmount(): Unit = amount = maximum
    def reduceAmount(rate: Int): Unit = amount -= rate
    def need(): Unit
    override def toString(): String = amount.toString + " " + metric.toString + " of " + name.toString()
    def getEvalString(): String = ""
    def difference(): Int = maximum - amount
}
