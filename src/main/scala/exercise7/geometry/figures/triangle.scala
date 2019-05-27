package exercise7.geometry.figures

import java.awt.geom.Point2D
import exercise7.geometry.functions._

class Triangle(val point1: Point2D, val point2: Point2D, val point3: Point2D) extends Figure{
    override def accept[T](visitor: VisitorFig[T]): T = visitor.visit(this)
    override def toString(): String = "triangle"
}