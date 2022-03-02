package Branch


import Script
import org.powbot.api.rt4.Bank
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent


class IsBankOpened(script: Script) : Branch<Script>(script, "Bank open") {
    override val successComponent: TreeComponent<Script> = ShouldWithdrawHouseTab(script)
    override val failedComponent: TreeComponent<Script> = MovingBranch(script)

    override fun validate(): Boolean {
        return Bank.opened()
    }
}