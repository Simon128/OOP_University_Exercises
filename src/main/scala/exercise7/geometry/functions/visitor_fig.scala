package exercise7.geometry.functions

import exercise7.geometry.figures._

trait VisitorFig[T]{
    def visit(fig: Circle): T
    def visit(fig: Square): T
    def visit(fig: Triangle): T
}