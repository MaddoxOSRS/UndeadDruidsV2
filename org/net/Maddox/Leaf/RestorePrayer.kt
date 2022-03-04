package Leaf

import Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Camera
import org.powbot.api.rt4.GameObject
import org.powbot.api.rt4.Objects
import org.powbot.api.rt4.Prayer
import org.powbot.api.rt4.walking.model.Skill
import org.powbot.api.script.tree.Leaf

class RestorePrayer (script: Script) : Leaf<Script>(script, "Restoring Prayer") {

    override fun execute() {
        val ALTAR = Objects.stream().type(GameObject.Type.INTERACTIVE).name("Altar").nearest().first()
        if (!ALTAR.valid() || !ALTAR.inViewport()) {
            Camera.turnTo(ALTAR)
            Condition.wait(ALTAR::inViewport, 500, 5)
        }
        if (ALTAR.interact("Pray-at")) {
            Condition.wait {Prayer.prayerPoints() == Skill.Prayer.realLevel() }
        }
    }
}