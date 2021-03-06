package org.net.maddox.extensions

import org.powbot.api.rt4.Npc
import org.powbot.api.rt4.Npcs

fun Npcs.nearestNpc(vararg names: String): Npc {
    return stream().name(*names).nearest().first()
}

fun Npcs.nearestNpc(vararg ids: Int): Npc {
    return stream().id(*ids).nearest().first()
}

fun Npcs.druid(vararg ids: Int): Npc {
    return stream().id(*ids).filtered { !it.healthBarVisible() || it.healthPercent() > 0 }.reachable().first()
}

