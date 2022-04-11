package org.net.maddox.leaf

import org.net.maddox.Configs
import org.net.maddox.Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Game
import org.powbot.api.rt4.Prayer
import org.powbot.api.script.tree.Leaf

class ActivatePrayer(script: Script) : Leaf<Script>(script, "Activating Prayers") {
    override fun execute() {
        if (Configs.usePiety && !Configs.useRigour) {
            Prayer.prayer(Prayer.Effect.PIETY, true)
            Prayer.prayer(Prayer.Effect.PROTECT_FROM_MAGIC, true)
            Game.closeOpenTab()
            Condition.wait { Prayer.prayerActive(Prayer.Effect.PROTECT_FROM_MAGIC) }
        } else
            if (Configs.useRigour && !Configs.usePiety) {
                Prayer.prayer(Prayer.Effect.RIGOUR, true)
                Prayer.prayer(Prayer.Effect.PROTECT_FROM_MAGIC, true)
                Game.closeOpenTab()
                Condition.wait { Prayer.prayerActive(Prayer.Effect.PROTECT_FROM_MAGIC) }
            } else
                Prayer.prayer(Prayer.Effect.PROTECT_FROM_MAGIC, true)
        Game.closeOpenTab()
        Condition.wait { Prayer.prayerActive(Prayer.Effect.PROTECT_FROM_MAGIC) }
    }
}