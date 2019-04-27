package exercise3.flexibels

class VariableArray() extends VariableStructure{
    private var content: Array[Any] = Array[Any]()

    override def add(o: Any) = {
        content :+= o
    }

    override def size(): Int = content.size

    override def remove(i: Int): Any = {
        var remove = content(i)
        content = content.patch(i, Nil, 1)
        return remove
    }

    override def get(i: Int): Any = content(i)

    override def isEmpty(): Boolean = content.size == 0

    override def toString(): String = "(" + content.mkString(",") + ")"
}
