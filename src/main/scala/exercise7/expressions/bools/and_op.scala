package exercise7.expressions.bools

import exercise7.expressions._

class AndOp(protected val operand1: Expression[Boolean], protected val operand2: Expression[Boolean]) extends BinaryOperation[Boolean]{
    def eval(): Boolean = (operand1.eval() && operand2.eval())
}