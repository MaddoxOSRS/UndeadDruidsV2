package org.net.maddox.leaf


import org.net.maddox.Script
import org.powbot.api.Condition
import org.powbot.api.script.tree.Leaf

class Chillax(script: Script) : Leaf<Script>(script, "Sippin' Tea") {

    override fun execute() {
        Condition.sleep()
    }
}