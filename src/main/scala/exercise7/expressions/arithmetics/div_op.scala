package exercise7.expressions.arithmetics

import exercise7.expressions._

class DivOp(protected val operand1: Expression[Int], protected val operand2: Expression[Int]) extends BinaryOperation[Int]{
    def eval(): Int = Math.round(operand1.eval() / operand2.eval())
}