package org.net.maddox.branch

import org.net.maddox.Constants
import org.net.maddox.Script
import org.net.maddox.leaf.MoveToBank
import org.net.maddox.leaf.OpenBank
import org.net.maddox.leaf.Teleporttohouse
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class MovetoBank(script: Script) : Branch<Script>(script, "Inventory is full, Banking.") {
    override val successComponent: TreeComponent<Script> = ShouldOpenBank(script)
    override val failedComponent: TreeComponent<Script> = Teleporttohouse(script)

    override fun validate(): Boolean {
        return Constants.OUTSIDE_HOUSE.contains(Players.local())
    }

    class ShouldOpenBank(script: Script) : Branch<Script>(script, "Opening the Bank") {
        override val successComponent: TreeComponent<Script> = OpenBank(script)
        override val failedComponent: TreeComponent<Script> = MoveToBank(script)

        override fun validate(): Boolean {
            return Constants.HOSIDIOUS_BANK.contains(Players.local())
        }
    }
}