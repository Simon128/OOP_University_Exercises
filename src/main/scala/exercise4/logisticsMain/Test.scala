package exercise4.logisticsMain

import exercise4.logisticsDefinitions._
import exercise4.logisticsEntities._

object Test{
    def main(args: Array[String]){
        var tank = new Tank("Dieter", 1200, 10)

        println(tank.fuelTank.toString)
        println(tank.ammoStorage.toString)
    }
}
