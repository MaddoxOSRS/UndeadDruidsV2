package org.net.maddox.leaf


import Constants
import org.powbot.api.script.tree.Leaf
import org.net.maddox.Script
import extensions.druid
import org.powbot.api.Condition
import org.powbot.api.rt4.*

class AttackDruid (script: Script) : Leaf<Script>(script, "Attacking Druid") {
    override fun execute() {
        val npc = Npcs.druid(Constants.DRUIDS)
        if (!npc.inViewport()) {
            Camera.turnTo(npc)
        }
            if (npc.inViewport() && npc.interact("Attack")) {
                Condition.wait({Players.local().healthBarVisible()}, 1000, 10)
            }
    }
}