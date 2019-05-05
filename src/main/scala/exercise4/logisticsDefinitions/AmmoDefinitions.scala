package exercise4.logisticsDefinitions

import exercise4.logisticsEntities._

trait Bullets extends Ammo{
    val calibre = Calibre.Bullet
    val metric = Metric.Belts

    override def need(): Unit = {
        Manager.getSupplyArray()(2) += difference()
    }
}

trait Rockets extends Ammo{
    val calibre = Calibre.Rocket
    val metric = Metric.Pods

    override def need(): Unit = {
        Manager.getSupplyArray()(3) += difference()
    }
}

trait Shells extends Ammo{
    val calibre = Calibre.Shell
    val metric = Metric.Batch

    override def need(): Unit = {
        Manager.getSupplyArray()(4) += difference()
    }
}