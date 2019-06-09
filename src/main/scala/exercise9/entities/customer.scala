package exercise9.entities

import exercise9.support._

class Customer(private val firstName: String, private val name: String, private var account: Double, private val trader: Trader){
    private val ID: String = createID()
    account = AmountHelper.adjustDouble(account)

    private def createID() = f"${trader.getCustomers().length+1}%06d${firstName(0)}-${name(0)}"

    def getID(): String = ID
    def getFName(): String = firstName
    def getName(): String = name
    def getAccount(): Double = account
    def addToAccount(a: Double) = account += a
    def subFromAccount(a: Double) = account -= a
    override def equals(other: Any): Boolean = other match{
        case customer: Customer => return customer.getID() == ID
        case _ => return false
    }
    override def toString(): String = s"Customer $ID : first name: $firstName : name : $name | has Account: $account"
}