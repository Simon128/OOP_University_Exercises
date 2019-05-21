package exercise7.expressions.arithmetics

import exercise7.expressions._

class SubOp(protected val operand1: Expression[Int], protected val operand2: Expression[Int]) extends BinaryOperation[Int]{
    def eval(): Int = operand1.eval() - operand2.eval()
}