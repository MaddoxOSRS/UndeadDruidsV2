package extensions

import org.powbot.api.rt4.Npc
import org.powbot.api.rt4.Npcs

fun Npcs.nearestNpc(vararg names: String): Npc {
    return stream().name(*names).nearest().first()
}

fun Npcs.nearestNpc(vararg ids: Int): Npc {
    return stream().id(*ids).nearest().first()
    //Npcs.nearestNpc(Constants.DRUIDS).interacting().valid() || Npcs.nearestNpc(Constants.DRUIDS).equals(Players.local())
}

fun Npcs.druid(vararg ids: Int): Npc {
   return stream().id(*ids).filtered { !it.healthBarVisible() || it.healthPercent() > 0 }.nearest().first()
}

