package org.net.maddox.leaf

import org.net.maddox.Script
import org.powbot.api.rt4.Movement
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Leaf

class DodgeMelee(script: Script) : Leaf<Script>(script, "Dodging Druid Melee") {
    override fun execute() {
        val stepsouth = Players.local().tile().derive(-1, +2)
        val stepnorth = Players.local().tile().derive(+1, -2)
        if (!stepnorth.reachable()) {
            Movement.step(stepsouth)
        } else {
            Movement.step(stepnorth)
        }
    }
}