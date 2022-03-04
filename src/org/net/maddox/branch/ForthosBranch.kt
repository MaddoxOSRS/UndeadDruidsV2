package org.net.maddox.branch

import org.net.maddox.Constants
import org.net.maddox.Script
import org.net.maddox.leaf.ActivatePrayer
import org.net.maddox.leaf.AttackDruid
import org.net.maddox.leaf.Chillax
import org.net.maddox.leaf.UseAltar
import org.powbot.api.rt4.Inventory
import org.powbot.api.rt4.Npcs
import org.powbot.api.rt4.Players
import org.powbot.api.rt4.Prayer
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent


class InventoryFull(script: Script) : Branch<Script>(script, "Inventory is full, Banking.") {
    override val successComponent: TreeComponent<Script> = MovetoBank(script)
    override val failedComponent: TreeComponent<Script> = AtDruids(script)

    override fun validate(): Boolean {
        return Inventory.isFull()
    }
}

class AtDruids(script: Script) : Branch<Script>(script, "At Druids") {
    override val successComponent: TreeComponent<Script> = CheckPrayer(script)
    override val failedComponent: TreeComponent<Script> = GOTODRUIDS(script)

    override fun validate(): Boolean {
        return Constants.DRUID_ATTACK_AREA.contains(Players.local())
    }
}

class CheckPrayer(script: Script) : Branch<Script>(script, "Activating Prayer") {
    override val successComponent: TreeComponent<Script> = RestorePrayer(script)
    override val failedComponent: TreeComponent<Script> = ActivatePrayer(script)

    override fun validate(): Boolean {
        return Prayer.prayerActive(Prayer.Effect.PROTECT_FROM_MAGIC)
    }
}

class RestorePrayer(script: Script) : Branch<Script>(script, "Initiating Prayer Restore") {
    override val successComponent: TreeComponent<Script> = UseAltar(script)
    override val failedComponent: TreeComponent<Script> = CombatBranch(script)

    override fun validate(): Boolean {
        return Prayer.prayerPoints() < 10
    }
}

class CombatBranch(script: Script) : Branch<Script>(script, "Initiating Druid Branches") {
    override val successComponent: TreeComponent<Script> = AttackDruid(script)
    override val failedComponent: TreeComponent<Script> = Chillax(script)

    override fun validate(): Boolean {
        val druid = Npcs.stream().id(Constants.DRUIDS_ID).nearest().first()
        return !Players.local().healthBarVisible() || Players.local().interacting() != druid
    }
}