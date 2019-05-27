package exercise7.binaryTrees

object Test{
    def main(args: Array[String]): Unit = {
        val t1 = new Tree(42, 
            new Tree(17, 
                new Tree(5, null, null), null), 
            new Tree(81, 
                new Tree(51, null, null), 
                new Tree(97, null, null))) 
        
        println( s"t1 = $t1 " ) 
        for (e <- t1) println (e)
    }
}