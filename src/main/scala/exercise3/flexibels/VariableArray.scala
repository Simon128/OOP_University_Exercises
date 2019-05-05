package exercise3.flexibels

class VariableArray() extends VariableStructure{
    private var content: Array[Any] = Array.fill(1)(null)

    private var _length: Int = 0

    override def add(o: Any) = {
        if(this.content(this.content.length - 1) == null)
            this.content(this.content.length - 1) = o
        else{
            var newArr: Array[Any] = Array.fill(this.content.length + 1)(null)

            for(i <- 0 until this.content.length)
                newArr(i) = this.content(i)
            
            newArr(newArr.length - 1) = o
            this.content = newArr
        }
        _length += 1
    }

    override def size(): Int = _length

    override def remove(i: Int): Any = {
        if(_length < i + 1 || this.content(i) == null)
            return null

        var result = this.content(i)
        this.content(i) = null

        for(ia <- i until _length - 1){
            this.content(ia) = this.content(ia + 1)
        }
        this.content(this.content.length - 1) = null
        _length -= 1
        return result
    }

    override def get(i: Int): Any = content(i)

    override def isEmpty(): Boolean = _length == 0

    override def toString(): String = "(" + content.filter(c => c != null).mkString(",") + ")"
}
