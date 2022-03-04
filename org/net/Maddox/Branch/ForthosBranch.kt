package Branch

import Constants
import Leaf.ActivatePrayer
import Leaf.AttackDruid
import Leaf.EnterForthos
import Leaf.Idle
import Leaf.MovetoDruids
import Leaf.OpenBank
import Script
import org.powbot.api.rt4.Combat
import org.powbot.api.rt4.Inventory
import org.powbot.api.rt4.Players
import org.powbot.api.rt4.Prayer
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent
import kotlin.random.Random

class ActivatePrayer(script: Script) : Branch<Script>(script, "Activating Prayer") {
    override val successComponent: TreeComponent<Script> = ActivatePrayer(script)
    override val failedComponent: TreeComponent<Script> = CombatBranch(script)

    override fun validate(): Boolean {
        return Constants.DRUID_ATTACK_AREA.contains(Players.local())
                && Inventory.stream().name("Teleport to house").isNotEmpty() &&
                !Prayer.prayerActive(Prayer.Effect.PROTECT_FROM_MAGIC)
    }
}

class CombatBranch(script: Script) : Branch<Script>(script, "Initiating Druid Branches") {
    override val successComponent: TreeComponent<Script> = AttackDruid(script)
    override val failedComponent: TreeComponent<Script> = Moving(script)

    override fun validate(): Boolean {
        return Constants.DRUID_ATTACK_AREA.contains(Players.local()) && Inventory.stream().name("Teleport to house").isNotEmpty() && Prayer.prayerActive(Prayer.Effect.PROTECT_FROM_MAGIC)
    }
}
class Idle(script: Script) : Branch<Script>(script, "Initiating Idle") {
    override val successComponent: TreeComponent<Script> = Idle(script)
    override val failedComponent: TreeComponent<Script> = RestorePrayer(script)

    override fun validate(): Boolean {
        return Players.local().healthBarVisible()
    }

class RestorePrayer(script: Script) : Branch<Script>(script, "Initiating Druid Branches") {
        override val successComponent: TreeComponent<Script> = Leaf.Idle(script)
        override val failedComponent: TreeComponent<Script> = (script)

        override fun validate(): Boolean {
            return Prayer.prayerPoints() < Random.nextInt(9, 20) || Prayer.prayerPoints() == 0
        }
}

class MovingtoDruids(script: Script) : Branch<Script>(script, "Moving to Druids") {
    override val successComponent: TreeComponent<Script> = MovetoDruids(script)
    override val failedComponent: TreeComponent<Script> = MovingBranch(script)

    override fun validate(): Boolean {
        return Constants.FORTHOS_DUNGEON.contains(Players.local()) && !Constants.DRUID_ATTACK_AREA.contains(Players.local())
    }
}

class MovingBranch(script: Script) : Branch<Script>(script, "Moving to Forthos") {
    override val successComponent: TreeComponent<Script> = EnterForthos(script)
    override val failedComponent: TreeComponent<Script> = OpenBank(script)

    override fun validate(): Boolean {
        return !Constants.FORTHOS_DUNGEON.contains(Players.local()) && Inventory.stream().name("Teleport to house")
            .isNotEmpty()
    }

}
}