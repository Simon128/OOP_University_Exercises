package exercise5.logisticsMain

import exercise5.logisticsDefinitions._
import exercise5.logisticsEntities._

object Test{
    def main(args: Array[String]){
        var ufo = new SpecialUfo("Dieter",100, 6)

        Manager.addVehicle(ufo)
        ufo.need()
        println(Manager.showOverallNeed())

        println(ufo.fuelTank.toString)
        println(ufo.ammoStorage.toString)
    }
}
