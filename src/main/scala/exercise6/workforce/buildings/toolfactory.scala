package exercise6.workforce.buildings

import exercise6.workforce.equipment._
import exercise6.workforce.servants._

object ToolFactory{
    def equip(worker: Worker): Unit = worker match{
        case w: Miner => if(!w.canWork()) w.receiveTool(new PickAxe())
        case w: Lumberjack => if(w.canWork()) w.receiveTool(new Axe())
        case w: Smith => if(w.canWork()) w.receiveTool(new Hammer())
        case w: Carpenter => if(w.canWork()) w.receiveTool(new Saw())
        case w: Farmer => if(w.canWork()) w.receiveTool(new Scythe())
    }
}