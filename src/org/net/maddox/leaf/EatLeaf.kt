package org.net.maddox.leaf

import org.net.maddox.Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Inventory
import org.powbot.api.rt4.Item
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Leaf

class EatLeaf(script: Script) : Leaf<Script>(script, "Restoring HP") {

    override fun execute() {
        val food = Inventory.stream().name(script.configuration.foodName).first()
        if (food != Item.Nil) {
            if (food.interact("Eat") && Condition.wait({ Players.local().animation() != -1 }, 500, 3)) {
                Condition.wait { !food.valid() }
            }
        }
    }
}