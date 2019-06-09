package exercise9.support

object AmountHelper{
    def adjustDouble(p: Double): Double = ((p* 100).round / 100.toDouble)
}