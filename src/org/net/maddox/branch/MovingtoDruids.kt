package org.net.maddox.branch

import org.net.maddox.Constants
import org.net.maddox.Script
import org.net.maddox.leaf.EnterForthos
import org.net.maddox.leaf.MovetoDruids
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class GoToDruids(script: Script) : Branch<Script>(script, "Going to Druids") {
    override val successComponent: TreeComponent<Script> = CheckPrayer(script)
    override val failedComponent: TreeComponent<Script> = MovingBranch(script)

    override fun validate(): Boolean {
        return Constants.DRUID_ATTACK_AREA.contains(Players.local())
    }

    class MovingBranch(script: Script) : Branch<Script>(script, "Moving to Forthos") {
        override val successComponent: TreeComponent<Script> = EnterForthos(script)
        override val failedComponent: TreeComponent<Script> = MovetoDruids(script)

        override fun validate(): Boolean {
            return !Constants.FORTHOS_DUNGEON.contains(Players.local())
        }
    }
}