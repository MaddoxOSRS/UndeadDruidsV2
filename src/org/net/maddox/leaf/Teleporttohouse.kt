package org.net.maddox.leaf

import extensions.count
import extensions.mustWithdrawItem
import org.net.maddox.Constants
import org.net.maddox.Script
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Leaf

class Teleporttohouse (script: Script) : Leaf<Script>(script, "Teleporting outside house") {

    override fun execute() {
        if (Inventory.count(Constants.ITEM_HOUSE_TELEPORT) == 0) {
            Bank.mustWithdrawItem(Constants.ITEM_HOUSE_TELEPORT, 1)
        }
    }
}