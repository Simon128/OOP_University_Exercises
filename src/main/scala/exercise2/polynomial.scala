package exercise2

import scala.collection._

private class Polynomial(private val koeffizienten: Array[Int]){
    val degree : Int = koeffizienten.length - 1

    def +(that: Polynomial): Polynomial = {
        var koeffBuffer = mutable.Buffer(this.koeffizienten: _*)
        var counter = 0

        for(k <- that.koeffizienten){
            if(counter < koeffBuffer.length) koeffBuffer(counter) = koeffBuffer(counter) + k
            else koeffBuffer += k
            counter += 1
        }
        return new Polynomial(koeffBuffer.toArray)
    }

    def -(that: Polynomial): Polynomial = {
        return this + new Polynomial(that.koeffizienten.map(x => x * -1))
    }

    // def *(that: Polynomial): Polynomial = {
    //     var koeffBuffer = mutable.Buffer[Int]()
    //     var currentDegree = 0

    // }

    override def toString(): String = {
        var result = ""
        var currentDegree = 0
        var first = true
        for(k <- koeffizienten){
            if(k != 0){
                if(first) first = false
                else result += " + "
                if(currentDegree == 0){
                    result += k.toString()
                }
                else{
                    result += k.toString() + "*x^" + currentDegree
                }
            }
            currentDegree += 1
        }
        return result
    }
}

// object Polynomial{
//     val x = new Polynomial(Array(0,1))
//     def const(v: Int): Polynomial = {
//         return new Polynomial(Array(v))
//     }
// }