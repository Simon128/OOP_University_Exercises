package exercise7.expressions

trait UnaryOperation[E]{
    protected val operand: Expression[E]
}