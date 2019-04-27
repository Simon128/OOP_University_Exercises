package exercise2

object OOP2 {
  def main(args: Array[String]): Unit = {
    
      var p1 = new Polynomial(Array(1, 2, 3, 4))
      val p2 = new Polynomial(Array(1, 3, 0, 2, 9, 8))

      p1 += p2
      println(p1)
  }
}