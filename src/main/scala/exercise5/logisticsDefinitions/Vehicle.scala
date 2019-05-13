package exercise5.logisticsDefinitions

import exercise5.logisticsEntities._

trait Vehicle{
    val name: String
    private var neededOil: Int = 0
    private var neededGrease: Int = 0
    val fuelTank: Fuel
    val ammoStorage: Ammo

    def need(): Unit = {
        fuelTank.need()
        ammoStorage.need()
        Manager.getSupplyArray()(6) += neededOil
        Manager.getSupplyArray()(7) += neededGrease
    }
    def reset(): Unit = {
        fuelTank.resetAmount()
        ammoStorage.resetAmount()
        neededOil = 0
        neededGrease = 0
    }
    protected def reduceOilAndGrease(): Unit = {
        // if(neededOil == 3 || neededGrease == 3)
        //     throw new Exception("neededOil and neededGrease reached already 0")

        if(neededOil < 3){
            neededOil += 1
            neededGrease += 1
        }
    }
    def reduceAll(intensity: Int): Unit 
    def getNeededOil(): Int = neededOil
    def getNeededGrease(): Int = neededGrease
}