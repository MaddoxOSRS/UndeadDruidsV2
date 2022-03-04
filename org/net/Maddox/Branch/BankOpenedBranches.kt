package Branch

import Leaf.CloseBank
import Leaf.WithdrawHouseTab
import Script
import org.powbot.api.rt4.Inventory.stream
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent


class ShouldWithdrawHouseTab(script: Script) : Branch<Script>(script, "Should withdraw tabs?") {
    override val successComponent: TreeComponent<Script> = WithdrawHouseTab(script)
    override val failedComponent: TreeComponent<Script> = ShouldCloseBank(script)

    override fun validate(): Boolean {
        return stream().name("Teleport to house").isEmpty() && Constants.HOSIDIOUS_BANK_AREA.contains(Players.local())
    }
}
class ShouldCloseBank(script: Script) : Branch<Script>(script, "Withdraw Tabs") {
    override val successComponent: TreeComponent<Script> = CloseBank(script)
    override val failedComponent: TreeComponent<Script> = WithdrawHouseTab(script)

    override fun validate(): Boolean {
        return stream().name("Teleport to house").isNotEmpty() && Constants.HOSIDIOUS_BANK_AREA.contains(Players.local())
    }
}