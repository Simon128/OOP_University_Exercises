package exercise4.logisticsEntities

import exercise4.logisticsDefinitions._

class Truck(val name: String, amountFuel: Int, amountAmmo: Int) extends Vehicle{
    val fuelTank: Fuel = new Diesel(amountFuel, 180)
    val ammoStorage: Ammo = new TruckAmmo(amountAmmo, 3)

    override def reduceAll(intensity: Int){
        fuelTank.reduceAmount(intensity)
        ammoStorage.reduceAmount(intensity)
    }
}

class Tank(val name: String, amountFuel: Int, amountAmmo: Int) extends Vehicle{
    val fuelTank: Fuel = new Diesel(amountFuel, 1200)
    val ammoStorage: Ammo = new TankAmmo(amountAmmo, 10)

    override def reduceAll(intensity: Int){
        fuelTank.reduceAmount(intensity)
        ammoStorage.reduceAmount(intensity)
    }
}

class Helicopter(val name: String, amountFuel: Int, amountAmmo: Int) extends Vehicle{
    val fuelTank: Fuel = new Kerosene(amountFuel, 500)
    val ammoStorage: Ammo = new HeliAmmo(amountAmmo, 2)

    override def reduceAll(intensity: Int){
        fuelTank.reduceAmount(intensity)
        ammoStorage.reduceAmount(intensity)
    }
}