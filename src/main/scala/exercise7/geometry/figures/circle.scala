package exercise7.geometry.figures

import java.awt.geom.Point2D
import exercise7.geometry.functions._

class Circle(val centre: Point2D, val radius: Int) extends Figure{
    override def accept[T](visitor: VisitorFig[T]): T = visitor.visit(this)
    override def toString(): String = "circle"
}