package Leaf

import Constants
import Script
import extensions.count
import extensions.mustWithdrawItem
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Leaf

class WithdrawHouseTab (script: Script) : Leaf<Script>(script, "Withdrawing tab") {

    override fun execute() {
        if (Inventory.count(Constants.ITEM_HOUSE_TELEPORT) == 0) {
            Bank.mustWithdrawItem(Constants.ITEM_HOUSE_TELEPORT, 1)
        }
    }
        }