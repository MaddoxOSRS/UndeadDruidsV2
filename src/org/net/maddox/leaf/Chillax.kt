package org.net.maddox.leaf


import org.powbot.api.Condition
import org.powbot.api.script.tree.Leaf
import org.net.maddox.Script

class Chillax (script: Script) : Leaf<Script>(script, "Chillax") {

    override fun execute() {
    Condition.sleep()
    }
}