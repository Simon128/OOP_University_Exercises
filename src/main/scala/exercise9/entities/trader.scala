package exercise9.entities

import exercise9.support._

class Trader(private var account: Double){
    private val supplieOrders: SupplieOrders = new SupplieOrders()
    private val warehouse: Warehouse = new Warehouse()
    private val sellOrders: SellOrders = new SellOrders()
    private var customers: List[Customer] = List()

    account = AmountHelper.adjustDouble(account)

    def getAccount(): Double = account
    def getWarehouse(): Warehouse = warehouse
    def getSellOrders(): SellOrders = sellOrders
    def getSupplieOrders(): SupplieOrders = supplieOrders
    def getCustomers(): List[Customer] = customers

    def addToAccount(a: Double) = account += AmountHelper.adjustDouble(a)
    def addToCustomerList(f: String, n: String, d: Double): String = {
        customers = customers ::: List(new Customer(f, n, d, this))
        return customers.last.getID()
    }
    def getCustomer(iD: String): Customer = {
        val optional = customers.find(_.getID() == iD)
        if(optional.isEmpty)
            throw new IllegalArgumentException()
        return optional.get
    }
    def getIncomingTitle(iD: String): (Good, Double, Int, String) = supplieOrders.getTask(iD)
    def getOutgoingTitle(iD: String): (Good, Double, Int, String) = sellOrders.getTask(iD)
    def addIncomingGoods(g: Good, p: Double, n: Int) = supplieOrders.addTask(g, p, n)
    def addOutgoingGoods(g: Good, p: Double, n: Int, c: Customer) = sellOrders.addTask(g, p, n, c)
    def payIncomingSupplies(iD: String) = {
        val order = supplieOrders.getTask(iD)
        addToAccount(-(order._2 * order._3))
        supplieOrders.removeTask(iD)
    }
    def proceedIncomingGoods(iD: String) = {
        val order = supplieOrders.getTask(iD)
        warehouse.addToStorage(order._1, order._3)
        payIncomingSupplies(iD)
    }
    def sellOutgoingOrders(iD: String) = {
        val order = sellOrders.getTask(iD)
        val sellCustomer = sellOrders.getCustomerToTask(iD)

        val foundCustomer = customers.find(_ == sellCustomer)
        
        if(foundCustomer.isEmpty)
            throw new IllegalArgumentException(s"could not find customer $sellCustomer in traders customer list")
        
        foundCustomer.get.subFromAccount((order._2 * order._3))
        addToAccount((order._2 * order._3))
        sellOrders.removeTask(iD)
    }
    def proceedOutgoingGoods(iD: String) = {
        val order = sellOrders.getTask(iD)
        warehouse.removeFromStorage(order._1, order._3)
        sellOutgoingOrders(iD)
    }
    def printIDListIncomingGood(g: Good): Unit = {
        val iterator = supplieOrders.iDIterator(g) 
        var counter = 1
        while(iterator.hasNext){
            println(s"$counter. position for incoming ${g.name} has ID: ${iterator.next._4}")
            counter += 1
        }
    }
    def printIDListOutgoingGood(g: Good): Unit = {
        val iterator = sellOrders.iDIterator(g)
        var counter = 1
        while(iterator.hasNext){
            println(s"$counter. position for outgoing ${g.name} has ID: ${iterator.next._4}")
            counter += 1
        }
    }
}