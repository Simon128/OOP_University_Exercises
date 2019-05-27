package exercise7.geometry.functions

import exercise7.geometry.figures._

class SurfaceFormula extends VisitorFig[Double]{
    override def visit(fig: Circle): Double = {
        return Math.PI * (fig.radius * fig.radius)
    }
    override def visit(fig: Square): Double = {
        return fig.length * fig.height
    }
    override def visit(fig: Triangle): Double = {
        val s = (fig.point1.distance(fig.point2)
            + fig.point2.distance(fig.point3)
            + fig.point3.distance(fig.point1)) / 2
        return Math.sqrt(
            s * (s - fig.point1.distance(fig.point2))
            * (s - fig.point2.distance(fig.point3))
            * (s - fig.point3.distance(fig.point1))
        )
    }
}