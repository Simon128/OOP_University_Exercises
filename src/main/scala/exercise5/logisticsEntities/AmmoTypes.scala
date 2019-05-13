package exercise5.logisticsEntities

import exercise5.logisticsDefinitions._

class TruckAmmo(amount: Int, val maximum: Int = 0) extends Bullets{
    super.setAmount(amount)
}

class TankAmmo(amount: Int, val maximum: Int = 0) extends Bullets with Shells{    
    val bullet: TruckAmmo = new TruckAmmo(amount, maximum)
    override val calibre = Calibre.Shell
    override val metric = Metric.Batch

    super.setAmount(amount)

    override def need(): Unit = {
        super.need()
        bullet.need()
    }

    override def resetAmount(): Unit = {
        super.resetAmount()
        bullet.resetAmount()
    }

    override def reduceAmount(rate: Int): Unit = {
        super.reduceAmount(rate)
        bullet.reduceAmount(rate)
    }

    override def toString(): String = super.toString + " & " + bullet.toString
}

class HeliAmmo(amount: Int, val maximum: Int = 0) extends Bullets with Rockets{    
    val bullet: TruckAmmo = new TruckAmmo(amount, maximum)
    override val calibre = Calibre.Rocket
    override val metric = Metric.Pods

    super.setAmount(amount)

    override def need(): Unit = {
        super.need()
        bullet.need()
    }

    override def resetAmount(): Unit = {
        super.resetAmount()
        bullet.resetAmount()
    }

    override def reduceAmount(rate: Int): Unit = {
        super.reduceAmount(rate)
        bullet.reduceAmount(rate)
    }

    override def toString(): String = super.toString + " & " + bullet.toString
}

class AllAmmo(amount: Int, val maximum: Int = 0) extends Bullets with Shells with Rockets{
    val bulletShells: TankAmmo = new TankAmmo(amount, maximum)
    override val calibre = Calibre.Rocket
    override val metric = Metric.Pods

    super.setAmount(amount)

    override def need(): Unit = {
        super.need()
        bulletShells.need()
    }

    override def resetAmount(): Unit = {
        super.resetAmount()
        bulletShells.resetAmount()
    }

    override def reduceAmount(rate: Int): Unit = {
        super.reduceAmount(rate)
        bulletShells.reduceAmount(rate)
    }

    override def toString(): String = super.toString + " & " + bulletShells.toString
}