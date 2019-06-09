package exercise9.executable

import exercise9.entities._

object Test {
    def main(args: Array[String]): Unit = {
      val trader: Trader = new Trader(150000.458)
      println("Trader-Account: " + trader.getAccount())
      println()
      println("Karl Müller added with ID: " + trader.addToCustomerList("Karl", "Müller", 250.0))
      println("Heinz Meier added with ID: " + trader.addToCustomerList("Heinz", "Meier", 400.0))
      println()
      val nail: Good = new Good("Nail", 0.10)
      val hammer: Good = new Good("Hammer", 7.50)
      trader.addIncomingGoods(nail, 0.08, 10000)
      trader.addIncomingGoods(nail, 0.08, 5000)
      trader.addIncomingGoods(hammer, 6.90, 100)
      trader.printIDListIncomingGood(nail)
      trader.printIDListIncomingGood(hammer)     
      println()
      println(trader.getSupplieOrders().getStringTask("1-Nail-10000"))
      println(trader.getSupplieOrders().getStringTask("2-Nail-5000"))
      println()
      trader.proceedIncomingGoods("1-Nail-10000")
      println("Trader-Account: " + trader.getAccount())
      trader.getWarehouse.printTitle(nail)
      println()
      trader.proceedIncomingGoods("2-Nail-5000")
      trader.proceedIncomingGoods("3-Hammer-100")
      println("Trader-Account: " + trader.getAccount())
      trader.getWarehouse().printStorage()
      println()
      trader.addOutgoingGoods(nail, 0.11, 1000, trader.getCustomer("000001K-M"))
      trader.printIDListOutgoingGood(nail)
      println(trader.getSellOrders().getStringTask("1-Nail-1000"))
      println(trader.getSellOrders().getCustomerToTask("1-Nail-1000"))
      println()
      trader.proceedOutgoingGoods("1-Nail-1000")
      trader.printIDListOutgoingGood(nail)
      trader.getWarehouse.printTitle(nail)
      println("Trader-Account: " + trader.getAccount())
      println(trader.getCustomer("000001K-M"))
    }
}