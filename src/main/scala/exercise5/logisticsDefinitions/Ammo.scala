package exercise5.logisticsDefinitions

import exercise5.logisticsEntities.Calibre._
import exercise5.logisticsEntities.Metric._

trait Ammo{
    private var amount: Int = 0
    val maximum: Int
    val calibre: Calibre
    val metric: Metric

    def getAmount(): Int = amount
    protected def setAmount(a: Int): Unit = amount = a
    def resetAmount(): Unit = amount = maximum
    def reduceAmount(rate: Int): Unit = amount -= rate
    def need(): Unit 
    override def toString(): String = amount.toString + " " + metric.toString + " of " + calibre.toString
    def difference(): Int = maximum - amount
    def getEvalString(): String = ""
}