package exercise9.entities

import exercise9.support._

class Good(val name: String, private var price: Double){

    price = AmountHelper.adjustDouble(price)

    def getPrice(): Double = price
    def setPrice(p: Double) = price = AmountHelper.adjustDouble(p)
    override def equals(other: Any): Boolean = other match{
        case good: Good => return good.getPrice() == price && good.name == name
        case _ => return false
    } 
    override def toString(): String = s"Good $name | has market price of: $price"
}