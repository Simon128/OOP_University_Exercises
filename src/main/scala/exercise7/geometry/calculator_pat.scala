package exercise7.geometry

import exercise7.geometry.figures._
import exercise7.geometry.functions._

class CalculatorPat{
    def calcSurfaceSize(fig: Figure): Double = {
        fig match{
            case f: Square => f.length * f.height
            case f: Circle => Math.PI * (f.radius * f.radius)
            case _ => return -1L
        }
    }
}