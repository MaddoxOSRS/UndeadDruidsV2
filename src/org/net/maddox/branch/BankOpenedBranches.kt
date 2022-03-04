package org.net.maddox.branch

import org.net.maddox.leaf.*
import org.net.maddox.Script
import org.powbot.api.rt4.Inventory.stream
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent


class ShouldWithdrawHouseTab(script: Script) : Branch<Script>(script, "Should withdraw tabs?") {
    override val successComponent: TreeComponent<Script> = WithdrawHouseTab(script)
    override val failedComponent: TreeComponent<Script> = CloseBank(script)

    override fun validate(): Boolean {
        return stream().name("Teleport to house").isEmpty()
    }
}