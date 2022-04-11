package org.net.maddox.branch

import org.net.maddox.Configs
import org.net.maddox.Script
import org.net.maddox.leaf.CloseBank
import org.net.maddox.leaf.WithdrawFood
import org.net.maddox.leaf.WithdrawHouseTab
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent


class ShouldWithdrawHouseTab(script: Script) : Branch<Script>(script, "Should withdraw tabs?") {
    override val successComponent: TreeComponent<Script> = WithdrawHouseTab(script)
    override val failedComponent: TreeComponent<Script> = ShouldWithdrawFood(script)

    override fun validate(): Boolean {
        return Inventory.stream().name("Teleport to house").isEmpty()
    }

    class ShouldWithdrawFood(script: Script) : Branch<Script>(script, "Should withdraw food?") {
        override val successComponent: TreeComponent<Script> = WithdrawFood(script)
        override val failedComponent: TreeComponent<Script> = CloseBank(script)

        override fun validate(): Boolean {
            return Configs.usefood && Inventory.stream().name(script.configuration.foodName).isEmpty()
        }
    }
}