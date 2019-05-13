package exercise4.logisticsDefinitions

import exercise4.logisticsEntities.Metric._
import exercise4.logisticsEntities.FuelName._

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
