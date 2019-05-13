package exercise5.logisticsEntities

object FuelName extends Enumeration{
    type FuelName = Value
    val Diesel: FuelName = Value("diesel")
    val Kerosene: FuelName = Value("kerosene")
    val Deuterium: FuelName = Value("deuterium")
}