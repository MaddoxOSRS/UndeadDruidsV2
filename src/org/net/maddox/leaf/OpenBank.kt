package org.net.maddox.leaf

import org.net.maddox.Script
import org.powbot.api.rt4.Bank
import org.powbot.api.script.tree.Leaf

class OpenBank(script: Script) : Leaf<Script>(script, "Opening bank") {

    override fun execute() {
        Bank.open()
    }

}