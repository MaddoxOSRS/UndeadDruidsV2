package org.net.maddox.leaf
import Constants
import org.net.maddox.Script
import org.powbot.api.Condition
import org.powbot.api.rt4.GameObject
import org.powbot.api.rt4.Movement
import org.powbot.api.rt4.Objects
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Leaf

class EnterForthos (script: Script) : Leaf<Script>(script, "Entering Forthos Dungeon") {
    override fun execute() {
        val forthosentrance = Objects.stream().type(GameObject.Type.INTERACTIVE).id(Constants.FORTHOSENTRANCE).nearest().first()
        if (forthosentrance != GameObject.Nil && forthosentrance.inViewport()) {
            if (forthosentrance.interact("Climb-down")){
                Condition.wait { Constants.FORTHOS_DUNGEON.contains(Players.local()) }
            }
        } else Movement.step(Constants.FORTHOS_STAIRCASE)
    }
}