package org.net.maddox.leaf

import org.net.maddox.Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Game
import org.powbot.api.rt4.Prayer
import org.powbot.api.script.tree.Leaf

class ActivatePrayer(script: Script) : Leaf<Script>(script, "Activing Protect from Magic") {
    override fun execute() {
        Prayer.prayer(Prayer.Effect.PROTECT_FROM_MAGIC, true)
        Game.closeOpenTab()
        Condition.wait { Prayer.prayerActive(Prayer.Effect.PROTECT_FROM_MAGIC) }
    }
}