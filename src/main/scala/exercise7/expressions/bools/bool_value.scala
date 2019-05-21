package exercise7.expressions.bools

import exercise7.expressions._

class BoolValue(private val value: Boolean) extends Expression[Boolean]{
    def eval(): Boolean = value;
}