package org.net.maddox.leaf

import org.net.maddox.Constants
import org.net.maddox.Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Game
import org.powbot.api.rt4.Inventory
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Leaf

class Teleporttohouse(script: Script) : Leaf<Script>(script, "Teleporting outside house") {

    override fun execute() {
        if (Game.tab(Game.Tab.INVENTORY)) {
            val housetab = Inventory.stream().name("Teleport to house").first()
            if (housetab.interact("Outside")) {
                Condition.wait { Constants.OUTSIDE_HOUSE.contains(Players.local()) }
            }
        }
    }
}