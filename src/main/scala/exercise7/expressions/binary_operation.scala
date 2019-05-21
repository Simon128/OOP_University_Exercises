package exercise7.expressions

trait BinaryOperation[E]{
    protected val operand1: Expression[E]
    protected val operand2: Expression[E]
}