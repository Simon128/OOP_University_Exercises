package exercise9.entities

import exercise9.support._

class AmountEntry(private var amount: Double){
    def getAmount(): Double = amount
    def changeAmount(add: Double): Unit = amount += add
    override def toString(): String = AmountHelper.adjustDouble(amount).toString()
}