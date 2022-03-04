package org.net.maddox.leaf

import extensions.druid
import org.net.maddox.Constants
import org.net.maddox.Constants.NORTHERN_TILE
import org.net.maddox.Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Camera
import org.powbot.api.rt4.Movement
import org.powbot.api.rt4.Npcs
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Leaf

class DodgeMelee(script: Script) : Leaf<Script>(script, "Dodging Druid Melee") {
    override fun execute() {
        Movement.moveTo(NORTHERN_TILE);
    }
}