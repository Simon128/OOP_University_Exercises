package exercise5.logisticsEntities

object Calibre extends Enumeration{
    type Calibre = Value
    val Bullet: Calibre = Value("7,62 mm")
    val Shell: Calibre = Value("120 mm")
    val Rocket: Calibre = Value("70 mm")
}