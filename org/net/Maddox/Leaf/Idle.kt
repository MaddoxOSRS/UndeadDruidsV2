package Leaf

import extensions.druid
import org.powbot.api.Condition
import org.powbot.api.rt4.Npcs
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Leaf
import Script

class Idle (script: Script) : Leaf<Script>(script, "Idling") {

    override fun execute() {
    Condition.sleep()
    }
}