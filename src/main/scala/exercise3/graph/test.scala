package exercise3.graph

object Test{

    def main(args: Array[String]){
        val g = new Graph()

        for(n <- g.searchDeepAll()){
            println(n.toString())
        }
    }
}