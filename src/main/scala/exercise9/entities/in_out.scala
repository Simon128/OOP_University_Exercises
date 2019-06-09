package exercise9.entities

import scala.collection.mutable.ListBuffer

abstract class InOut{
    protected val tasks: ListBuffer[(Good, Double, Int, String)] = ListBuffer.empty[(Good, Double, Int, String)]
    private var cnt: Int = 0

    protected def createID(g: Good, n: Int) = {
        cnt += 1
        s"${cnt}-${g.name}-${n}"
    }
    def getTask(iD: String): (Good, Double, Int, String) = {
        var optional = tasks.find(_._4 == iD)
        if(optional.isEmpty)
            throw new IllegalArgumentException("invalid ID")
        else return optional.get
    }
    def removeTask(iD: String): Unit ={
        val optional = tasks.find(_._4 == iD)
        if(optional.isEmpty)
            throw new IllegalArgumentException(s"could not find task with ID $iD")
        tasks -= optional.get
    }
    def iDIterator(g: Good): Iterator[(Good, Double, Int, String)] = tasks.filter(_._1 == g).iterator
    def getStringTask(iD: String): String = {
        val task = getTask(iD)
        return s"[${task._1}] [buying/selling price: ${task._2}] [buying/selling amount: ${task._3}] [order-ID: ${task._4}]"
    }
}