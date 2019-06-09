package exercise9.entities

class SupplieOrders extends InOut{
    def addTask(g: Good, p: Double, n: Int) = {
        require(p >= 0, "price can't be negative")
        tasks += ((g, p, n, super.createID(g, n)))
    }
}