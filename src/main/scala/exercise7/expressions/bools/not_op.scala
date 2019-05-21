package exercise7.expressions.bools

import exercise7.expressions._

class NotOp(protected val operand: Expression[Boolean]) extends UnaryOperation[Boolean]{
    def eval(): Boolean = !operand.eval()
}