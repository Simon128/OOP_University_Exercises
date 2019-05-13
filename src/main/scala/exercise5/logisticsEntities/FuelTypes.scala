package exercise5.logisticsEntities

import exercise5.logisticsDefinitions._

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

class Deuterium(amount: Int, val maximum: Int = 0) extends Fuel{
    setAmount(amount)
    val name = FuelName.Deuterium
    val metric = Metric.Kg

    override def need(): Unit = {
        Manager.getSupplyArray()(2) += difference()
    }
}