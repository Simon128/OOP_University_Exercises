package exercise7.expressions.arithmetics

import exercise7.expressions._

class IntValue(private val value: Int) extends Expression[Int]{
    def eval(): Int = value
}