package exercise7.geometry

import exercise7.geometry.figures._
import exercise7.geometry.functions._

class CalculatorVis{
    def calcSurfaceSize(fig: Figure): Double = {
        return fig.accept(new SurfaceFormula())
    }
}