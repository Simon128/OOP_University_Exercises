package exercise4.logisticsEntities

import exercise4.logisticsDefinitions._
import scala.collection.mutable.ListBuffer

object Manager{
    private val vehicleList: ListBuffer[Vehicle] = new ListBuffer[Vehicle]()
    private val supplyArray: Array[Int] = Array.fill(7)(0)

    def getSupplyArray(): Array[Int] = supplyArray
    def addVehicle(v: Vehicle) = vehicleList += v
    def removeVehicle(v: Vehicle): Unit = vehicleList -= v 
    def resetVehicles(): Unit = {
        for(v <- vehicleList){
            v.reset()
            v.fuelTank.resetAmount()
            v.ammoStorage.resetAmount()
        }
        for(i <- 0 until supplyArray.length){
            supplyArray(i) = 0
        }
    }
    def showOverallNeed(): Unit = {
        println("Needed supplies for all vehicles:")
        println(supplyArray(0).toString + " " + Metric.Litre + " " + FuelName.Diesel)
        println(supplyArray(1).toString + " " + Metric.Litre + " " + FuelName.Kerosene)
        println(supplyArray(2).toString + " " + Metric.Belts + " " + Calibre.Bullet)
        println(supplyArray(3).toString + " " + Metric.Batch + " " + Calibre.Shell)
        println(supplyArray(4).toString + " " + Metric.Pods + " " + Calibre.Rocket)
        println(supplyArray(5).toString + " cans oil")
        println(supplyArray(6).toString + " packs Grease")
    }
}