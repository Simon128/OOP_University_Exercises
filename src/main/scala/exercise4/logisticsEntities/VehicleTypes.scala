package exercise4.logisticsEntities

import exercise4.logisticsDefinitions._

trait VehicleImpl extends Vehicle{
    override def reduceAll(intensity: Int){
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