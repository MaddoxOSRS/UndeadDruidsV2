package org.net.maddox.leaf


import org.net.maddox.Constants
import org.net.maddox.Script
import org.powbot.api.rt4.Movement
import org.powbot.api.script.tree.Leaf

class MovetoDruids(script: Script) : Leaf<Script>(script, "Moving to Undead Druids") {
    override fun execute() {
        Movement.moveTo(Constants.DRUID_AREA.randomTile)
    }
}