package Branch

import Constants
import Leaf.AttackDruid
import Leaf.EnterForthos
import Leaf.MovetoDruids
import Leaf.WithdrawHouseTab
import Script
import org.powbot.api.rt4.Inventory
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class MovingBranch(script: Script) : Branch<Script>(script, "Moving to Forthos") {
    override val successComponent: TreeComponent<Script> = EnterForthos(script)
    override val failedComponent: TreeComponent<Script> = WithdrawHouseTab(script)

    override fun validate(): Boolean {
        return Inventory.stream().name(Constants.ITEM_HOUSE_TELEPORT).isNotEmpty()
    }

class CombatBranch(script: Script) : Branch<Script>(script, "Initiating Druid Branches") {
        override val successComponent: TreeComponent<Script> = AttackDruid(script)
        override val failedComponent: TreeComponent<Script> = MovingtoDruids(script)

        override fun validate(): Boolean {
            return Constants.DRUID_ATTACK_AREA.contains(Players.local()) && !Inventory.isFull()
        }
    }
    class MovingtoDruids(script: Script) : Branch<Script>(script, "Moving to Druids") {
        override val successComponent: TreeComponent<Script> = CombatBranch(script)
        override val failedComponent: TreeComponent<Script> = EnterForthos(script)

        override fun validate(): Boolean {
            return Constants.FORTHOS_DUNGEON.contains(Players.local()) && !Constants.DRUID_ATTACK_AREA.contains(Players.local())
        }
    }
}