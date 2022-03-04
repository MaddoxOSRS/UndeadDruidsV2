package Leaf


import Constants
import org.powbot.api.script.tree.Leaf
import Script
import extensions.druid
import extensions.nearestNpc
import org.powbot.api.Condition
import org.powbot.api.Notifications
import org.powbot.api.rt4.*
import org.powbot.mobile.script.ScriptManager

class AttackDruid  (script: Script) : Leaf<Script>(script, "Looting Items") {
    override fun execute() {
        val npc = Npcs.druid(Constants.DRUIDS)
            if (npc.inViewport() && npc.interact("Attack")) {
                Condition.wait({Players.local().healthBarVisible()}, 1000, 10)
            }
    }
}