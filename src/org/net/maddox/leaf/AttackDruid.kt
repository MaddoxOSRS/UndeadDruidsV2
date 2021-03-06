package org.net.maddox.leaf


import org.net.maddox.Constants
import org.net.maddox.Script
import org.net.maddox.extensions.druid
import org.powbot.api.Condition
import org.powbot.api.rt4.Camera
import org.powbot.api.rt4.Npcs
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Leaf

class AttackDruid(script: Script) : Leaf<Script>(script, "Attacking Druid") {
    override fun execute() {
        val npc = Npcs.druid(Constants.DRUIDS_ID)
        if (npc.inViewport()) {
            if (npc.interact("Attack")) {
                Condition.wait { Players.local().interacting() == npc }
            }
        } else Camera.turnTo(npc)
    }
}