package exercise4.logisticsEntities

object Metric extends Enumeration{
    type Metric = Value
    val Litre: Metric = Value("litres")
    val Gallons: Metric = Value("gallons")
    val Belts: Metric = Value("belts")
    val Pods: Metric = Value("pods")
    val Batch: Metric = Value("batches")
}