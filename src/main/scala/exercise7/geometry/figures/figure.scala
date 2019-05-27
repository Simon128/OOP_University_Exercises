package exercise7.geometry.figures

import exercise7.geometry.functions._

trait Figure{
    def accept[T](visitor: VisitorFig[T]): T
}