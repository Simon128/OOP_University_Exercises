package exercise9.entities

import scala.collection.mutable.ListBuffer

class SellOrders extends InOut{
    private val buyers: ListBuffer[(Customer, String)] = ListBuffer.empty[(Customer, String)]

    def getCustomerToTask(iD: String): Customer = {
        val optional = buyers.find(_._2 == iD)
        if(optional.isEmpty)
            throw new IllegalArgumentException(s"customer with order-ID $iD does not exist")
        return optional.get._1
    }
    def addTask(g: Good, p: Double, n: Int, c: Customer) = {
        require(p >= 0, "price can't be negative")
        val id = super.createID(g, n)
        tasks += ((g, p, n, id))
        buyers += ((c, id))
    }
    override def removeTask(iD: String): Unit = {
        super.removeTask(iD)
        buyers.remove(buyers.indexWhere(_._2 == iD))
    }
}