package org.net.maddox.branch

import org.net.maddox.Configs
import org.net.maddox.Constants
import org.net.maddox.Script
import org.net.maddox.leaf.*
import org.powbot.api.rt4.*
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent


class InventoryFull(script: Script) : Branch<Script>(script, "Inventory is full, Banking.") {
    override val successComponent: TreeComponent<Script> = MovetoBank(script)
    override val failedComponent: TreeComponent<Script> = AtDruids(script)

    override fun validate(): Boolean {
        return Combat.healthPercent() <= 35 || Inventory.isFull() || Inventory.stream().name("Teleport to house")
            .isEmpty() || Inventory.stream().name(script.configuration.foodName).isEmpty()

    }
}

class AtDruids(script: Script) : Branch<Script>(script, "At Druids") {
    override val successComponent: TreeComponent<Script> = PickupLoot(script)
    override val failedComponent: TreeComponent<Script> = GoToDruids(script)

    override fun validate(): Boolean {
        return Constants.DRUID_ATTACK_AREA.contains(Players.local())
    }
}


class PickupLoot(script: Script) : Branch<Script>(script, "Looting Items") {
    override val successComponent: TreeComponent<Script> = LootItems(script)
    override val failedComponent: TreeComponent<Script> = EatFood(script)
    override fun validate(): Boolean {
        return GroundItems.stream().id(*Constants.ITEMS_TO_LOOT).within(Constants.DRUID_ATTACK_AREA).isNotEmpty()
    }
}

class EatFood(script: Script) : Branch<Script>(script, "Initiating Prayer Restore") {
    override val successComponent: TreeComponent<Script> = EatLeaf(script)
    override val failedComponent: TreeComponent<Script> = RestorePrayer(script)

    override fun validate(): Boolean {
        return Configs.usefood && Combat.healthPercent() <= 65
    }
}

class RestorePrayer(script: Script) : Branch<Script>(script, "Initiating Prayer Restore") {
    override val successComponent: TreeComponent<Script> = UseAltar(script)
    override val failedComponent: TreeComponent<Script> = CheckPrayer(script)

    override fun validate(): Boolean {
        return Prayer.prayerPoints() < 25
    }
}

class CheckPrayer(script: Script) : Branch<Script>(script, "Activating Prayer") {
    override val successComponent: TreeComponent<Script> = CombatBranch(script)
    override val failedComponent: TreeComponent<Script> = ActivatePrayer(script)

    override fun validate(): Boolean {
        return Prayer.prayerActive(Prayer.Effect.PROTECT_FROM_MAGIC)
    }
}

class CombatBranch(script: Script) : Branch<Script>(script, "Initiating Druid Branches") {
    override val successComponent: TreeComponent<Script> = AttackDruid(script)
    override val failedComponent: TreeComponent<Script> = AvoidMelee(script)

    override fun validate(): Boolean {
        return Players.local().interacting() == Actor.Nil || Players.local().interacting().healthPercent() == 0
    }

    class AvoidMelee(script: Script) : Branch<Script>(script, "Avoiding Melee") {
        override val successComponent: TreeComponent<Script> = DodgeMelee(script)
        override val failedComponent: TreeComponent<Script> = Chillax(script)

        override fun validate(): Boolean {
            return Npcs.stream().within(1).id(Constants.DRUIDS_ID).interactingWithMe().isNotEmpty() && Configs.useRanged
        }
    }
}