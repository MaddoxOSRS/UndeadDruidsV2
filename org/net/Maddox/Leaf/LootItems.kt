package Leaf
import Constants
import Script
import org.powbot.api.Condition
import org.powbot.api.rt4.*
import org.powbot.api.script.tree.Leaf

class LootItems (script: Script) : Leaf<Script>(script, "Looting Items") {
    override fun execute() {
        val Item = Objects.stream().type(GameObject.Type.INTERACTIVE).id(Constants.FORTHOSENTRANCE).nearest().first()
        if (Item.valid() && Item.inViewport()) {
            if (Item.interact("Take")){
                Condition.wait { Constants.FORTHOS_DUNGEON.contains(Players.local()) }
            }
        } else Movement.step(Constants.FORTHOS_STAIRCASE)
    }
}