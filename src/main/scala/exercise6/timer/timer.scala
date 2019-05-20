package exercise6.timer

class Timer{
    var time: Int = 0
    var endTime: Long = 0
    private var state: State = SetSecondsState

    val Billion: Long = 1000000000

    def tick(): Unit = state.tick()
    def up(): Unit = state.up()
    def down(): Unit = state.down()
    def mode(): Unit = state.mode()
    def start(): Unit = state.start()
    def isBeeping(): Boolean = state.isBeeping()
    def isRunning(): Boolean = (state == CountdownState) || isBeeping()

    def remainingTime(): Int = nanoToSec(endTime - System.nanoTime()).toInt

    private def nanoToSec(nano: Long) = nano / Billion
    private def secToNano(sec: Long) = sec * Billion

    private abstract class State{
        def tick(): Unit = {}
        def up(): Unit = {}
        def down(): Unit = {}
        def mode(): Unit = {}
        def start(): Unit = {}
        def isBeeping(): Boolean = state == BeepingState
    }

    private object SetSecondsState extends State{
        override def mode(): Unit = state = SetMinutesState
        override def start(): Unit = {
            state = CountdownState
            endTime = System.nanoTime() + secToNano(time)
        }
        override def up(): Unit = {
            if(time != Int.MaxValue)
                time += 1
        }
        override def down(): Unit = {
            if(time > 0)
                time -= 1
        }
    }

    private object SetMinutesState extends State{
        override def mode(): Unit = {
            state = SetSecondsState
        }
        override def start(): Unit = {
            state = CountdownState
            endTime = System.nanoTime() + secToNano(time)
        }
        override def up(): Unit = {
            if(time < (Int.MaxValue - 59))
                time += 60
        }
        override def down(): Unit = {
            if(time > 59)
                time -= 60
        }
    }

    private object CountdownState extends State{
        override def start(): Unit = {
            state = SetSecondsState
            time = remainingTime()
        }
        override def tick(): Unit = {
            if(System.nanoTime() >= endTime){
                state = BeepingState
                endTime = System.nanoTime() + secToNano(5) 
            }
        }
    }

    private object BeepingState extends State{
        override def tick(): Unit = {
            if(System.nanoTime() >= endTime)
                state = SetSecondsState
        }
    }
}