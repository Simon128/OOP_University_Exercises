package exercise7.expressions.arithmetics

import exercise7.expressions._

class NegOp(protected val operand: Expression[Int]) extends UnaryOperation[Int]{
    def eval(): Int = -(operand.eval())
}