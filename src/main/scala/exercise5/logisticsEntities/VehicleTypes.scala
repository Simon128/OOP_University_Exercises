package exercise5.logisticsEntities

import exercise5.logisticsDefinitions._

abstract class VehicleImpl extends Vehicle{
    override def reduceAll(intensity: Int) = {
        fuelTank.reduceAmount(intensity)
        ammoStorage.reduceAmount(intensity)

        // for(i <- 0 until intensity){
        //     super.reduceOilAndGrease()
        // }
    }
}

class Truck(val name: String, amountFuel: Int, amountAmmo: Int) extends VehicleImpl{
    val fuelTank: Fuel = new Diesel(amountFuel, 180)
    val ammoStorage: Ammo = new TruckAmmo(amountAmmo, 3)    
}

class Tank(val name: String, amountFuel: Int, amountAmmo: Int) extends VehicleImpl{
    val fuelTank: Fuel = new Diesel(amountFuel, 1200)
    val ammoStorage: Ammo = new TankAmmo(amountAmmo, 10)
}

class Helicopter(val name: String, amountFuel: Int, amountAmmo: Int) extends VehicleImpl{
    val fuelTank: Fuel = new Kerosene(amountFuel, 500)
    val ammoStorage: Ammo = new HeliAmmo(amountAmmo, 2)
}

class SpecialUfo(val name: String, amountFuel: Int, amountAmmo: Int) extends VehicleImpl{
    val fuelTank: Fuel = new Deuterium(amountFuel, 200)
    val ammoStorage: Ammo = new AllAmmo(amountAmmo, 12)

    override def reduceAll(intensity: Int) = {
        fuelTank.reduceAmount(intensity * 50)
        ammoStorage.reduceAmount(intensity * 2)
    }
}