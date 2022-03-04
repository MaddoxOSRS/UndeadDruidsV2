package org.net.maddox.leaf


import org.powbot.api.script.tree.Leaf
import org.net.maddox.Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Movement
import org.powbot.api.rt4.Players

class MovetoDruids (script: Script) : Leaf<Script>(script, "Moving to Undead Druids") {
    override fun execute() {
        Movement.moveTo(Constants.DRUID_AREA.randomTile)
        Condition.wait( { Constants.DRUID_ATTACK_AREA.contains(Players.local()) }, 250, 5)
    }
}