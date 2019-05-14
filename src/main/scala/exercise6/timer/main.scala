package exercise6.timer

object Main{
    def main(args: Array[String]): Unit = {
        var timer = new Timer()
        
        //5 sek
        for(i <- 0 until 5)
            timer.up()

        timer.start()
        println(s"Timer running (${remainingTimeAsString(timer)}) ...")

        while(timer.isRunning() || timer.isBeeping()){
            Thread.sleep(1000)
            timer.tick()
            
            if(timer.isRunning() && !timer.isBeeping())
                println(s"Timer running (${remainingTimeAsString(timer)}) ...")

            if(timer.isBeeping())
                println(s"Timer beeping (${remainingTimeAsString(timer)}) ...")
        }
    }

    private def remainingTimeAsString(timer: Timer): String = {
        return math.floor((timer.remainingTime() / 60)).toInt.toString + ":" + (timer.remainingTime() % 60).toString()
    }
}