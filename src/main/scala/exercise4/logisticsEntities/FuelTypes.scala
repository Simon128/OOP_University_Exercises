package exercise4.logisticsEntities

import exercise4.logisticsDefinitions._

class Diesel(amount: Int, val maximum: Int = 0) extends Fuel{
    setAmount(amount)
    val name = FuelName.Diesel
    val metric = Metric.Litre

    override def need(): Unit = {
        Manager.getSupplyArray()(0) += difference()
    }
}

class Kerosene(amount: Int, val maximum: Int = 0) extends Fuel{
    setAmount(amount)
    val name = FuelName.Kerosene
    val metric = Metric.Litre

    override def need(): Unit = {
        Manager.getSupplyArray()(1) += difference()
    }
}