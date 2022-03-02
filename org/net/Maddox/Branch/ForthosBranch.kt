package Branch

import Constants
import Leaf.EnterForthos
import Leaf.WithdrawHouseTab
import Script
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class MovingBranch(script: Script) : Branch<Script>(script, "Moving to Forthos") {
    override val successComponent: TreeComponent<Script> = EnterForthos(script)
    override val failedComponent: TreeComponent<Script> = WithdrawHouseTab(script)

    override fun validate(): Boolean {
        return Inventory.stream().name(Constants.ITEM_HOUSE_TELEPORT).isNotEmpty()
    }
}