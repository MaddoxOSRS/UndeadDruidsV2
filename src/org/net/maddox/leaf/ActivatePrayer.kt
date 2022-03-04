package org.net.maddox.leaf

import org.powbot.api.Condition
import org.powbot.api.script.tree.Leaf
import org.net.maddox.Script
import org.powbot.api.rt4.Prayer

class ActivatePrayer (script: Script) : Leaf<Script>(script, "Activing Protect from Magic") {
    override fun execute() {
        Prayer.prayer(Prayer.Effect.PROTECT_FROM_MAGIC, true)
            Condition.wait({ Prayer.prayerActive(Prayer.Effect.PROTECT_FROM_MAGIC)}, 1000, 10)
    }
}