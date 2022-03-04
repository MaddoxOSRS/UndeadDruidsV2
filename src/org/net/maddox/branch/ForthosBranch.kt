package org.net.maddox.branch

import org.net.maddox.Constants
import org.net.maddox.leaf.*
import org.net.maddox.Script
import org.powbot.api.rt4.Inventory
import org.powbot.api.rt4.Players
import org.powbot.api.rt4.Prayer
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent


class InventoryFull(script: Script) : Branch<Script>(script, "Inventory is full, Banking.") {
    override val successComponent: TreeComponent<Script> = ActivatePrayer(script)
    override val failedComponent: TreeComponent<Script> = CombatBranch(script)

    override fun validate(): Boolean {
        return Constants.DRUID_ATTACK_AREA.contains(Players.local())
                && Inventory.stream().name("Teleport to house").isNotEmpty() &&
                !Prayer.prayerActive(Prayer.Effect.PROTECT_FROM_MAGIC)
    }
}

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
    override val failedComponent: TreeComponent<Script> = Idle.MovingtoDruids(script)

    override fun validate(): Boolean {
        return Constants.DRUID_ATTACK_AREA.contains(Players.local()) && Inventory.stream().name("Teleport to house").isNotEmpty()
                && Prayer.prayerActive(Prayer.Effect.PROTECT_FROM_MAGIC) && !Players.local().healthBarVisible()
    }
}
class Idle(script: Script) : Branch<Script>(script, "Initiating Idle") {
    override val successComponent: TreeComponent<Script> = Chillax(script)
    override val failedComponent: TreeComponent<Script> = RestorePrayer(script)

    override fun validate(): Boolean {
        return Players.local().healthBarVisible()
    }

class RestorePrayer(script: Script) : Branch<Script>(script, "Initiating Prayer Restore") {
        override val successComponent: TreeComponent<Script> = UseAltar(script)
        override val failedComponent: TreeComponent<Script> = CombatBranch(script)

        override fun validate(): Boolean {
            return Prayer.prayerPoints() < 20 || Prayer.prayerPoints() == 0
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