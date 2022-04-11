package org.net.maddox.leaf

import org.net.maddox.Script
import org.net.maddox.extensions.count
import org.net.maddox.extensions.mustWithdrawItem
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Leaf

class WithdrawFood(script: Script) : Leaf<Script>(script, "Withdrawing food") {

    override fun execute() {

        if (Inventory.count(script.configuration.foodName) == 0) {
            Bank.mustWithdrawItem(script.configuration.foodName, script.configuration.foodAmount)
        }
    }
}