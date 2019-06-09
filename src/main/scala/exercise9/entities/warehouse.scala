package exercise9.entities

import scala.collection.mutable.ListBuffer

class Warehouse{
    private val goods = ListBuffer.empty[(Good, AmountEntry)]

    def addToStorage(g: Good, n: Int): Unit = {
        for(good <- goods)
            if(good._1 == g) {
                good._2.changeAmount(n)
                return
            }
        goods += ((g, new AmountEntry(n)))
    }

    def removeFromStorage(g: Good, n: Int) = {
        val forRemoval = goods.find(_._1 == g)
        
        if(forRemoval.isEmpty)
            throw new IllegalArgumentException("good not found")

        if(forRemoval.get._2.getAmount() < n)
            throw new IllegalArgumentException("good amount not sufficient")
        
        if(forRemoval.get._2.getAmount() == n)
            goods -= forRemoval.get
        else
            goods(goods.indexOf(forRemoval.get))._2.changeAmount(-n)
    }

    private def printTuple(t: (Good, AmountEntry)) = {
        println(s"[${t._1}] [amount in storage: ${t._2}]")
    }

    def printTitle(g: Good) = {
        for(t <- goods){
            if(t._1 == g) printTuple(t)
        }
    }

    def printStorage() = goods.foreach(printTuple(_))
}