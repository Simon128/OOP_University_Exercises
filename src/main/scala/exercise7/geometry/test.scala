package exercise7.geometry

import exercise7.geometry.figures._
import exercise7.geometry.functions._
import java.awt.Point

object Test{
    def main(args: Array[String]): Unit ={
        val square = new Square(new Point(0, 0), 10, 5)

        val calc = new CalculatorVis();
        val size = calc.calcSurfaceSize(square)

        println(size)

        val calc2 = new CalculatorPat()
        val size2 = calc2.calcSurfaceSize(square)

        println(size2)
    }
}