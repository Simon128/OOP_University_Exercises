package exercise4.logisticsDefinitions

import exercise4.logisticsEntities._

trait Vehicle{
    val name: String
    private var neededOil: Int = 0
    private var neededGrease: Int = 0
    val fuelTank: Fuel
    val ammoStorage: Ammo

    def need(): Unit = {
        fuelTank.need()
        ammoStorage.need()
        Manager.getSupplyArray()(5) += neededOil
        Manager.getSupplyArray()(6) += neededGrease
    }
    def reset(): Unit = {
        neededOil = 0
        neededGrease = 0
    }
    protected def reduceOilAndGrease(): Unit = {
        if(neededOil == 3 || neededGrease == 3)
            throw new Exception("neededOil or neededGrease reached already 0")

        neededOil += 1
        neededGrease += 1
    }
    def reduceAll(intensity: Int): Unit 
    def getNeededOil(): Int = neededOil
    def getNeededGrease(): Int = neededGrease
}