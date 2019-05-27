package exercise7.geometry.figures

import java.awt.geom.Point2D
import exercise7.geometry.functions._

class Square(val upLeft: Point2D, val length: Int, val height: Int) extends Figure{
    override def accept[T](visitor: VisitorFig[T]): T = visitor.visit(this)
    override def toString(): String = "square"
}