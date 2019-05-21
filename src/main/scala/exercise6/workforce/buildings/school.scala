package exercise6.workforce.buildings

import exercise6.workforce.servants._

object School{
    private var wCnt: Int = 0

    def trainWorker(mi: Int, lj: Int, sm: Int, ca: Int, fa: Int): Array[Worker] = {
        return (Array.fill(mi)(new Miner("Miner")) 
            ++ Array.fill(lj)(new Lumberjack("Lumberjack")) 
            ++ Array.fill(sm)(new Smith("Smith")) 
            ++ Array.fill(ca)(new Carpenter("Carpenter")) 
            ++ Array.fill(fa)(new Farmer("Farmer")))
    }
}