package org.net.maddox.leaf

import org.net.maddox.Constants.DRUID_ATTACK_AREA
import org.net.maddox.Constants.ITEMS_TO_LOOT
import org.net.maddox.Script
import org.powbot.api.Condition
import org.powbot.api.rt4.GroundItems
import org.powbot.api.script.tree.Leaf

class LootItems(script: Script) : Leaf<Script>(script, "Looting Items") {
    override fun execute() {
        val item = GroundItems.stream().id(*ITEMS_TO_LOOT).within(DRUID_ATTACK_AREA).nearest().first()
        if (item.valid()) {
            if (item.interact("Take")) {
                Condition.wait { GroundItems.stream().id(*ITEMS_TO_LOOT).within(DRUID_ATTACK_AREA).isEmpty() }
            }
        }
    }
}