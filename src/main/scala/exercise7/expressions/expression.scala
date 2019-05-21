package exercise7.expressions

trait Expression[E]{
    def eval(): E
    override def toString(): String = eval.toString()
}