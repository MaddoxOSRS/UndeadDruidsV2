package org.net.maddox.leaf


import org.net.maddox.Constants
import org.net.maddox.Constants.TILE_DRUID
import org.net.maddox.Script
import org.powbot.api.Condition
import org.powbot.api.rt4.GroundItems
import org.powbot.api.rt4.Npcs
import org.powbot.api.script.tree.Leaf

class Chillax(script: Script) : Leaf<Script>(script, "Sippin' Tea") {

    override fun execute() {
        var druid = Npcs.stream().id(Constants.DRUIDS_ID).first()
        if (druid.interacting().animation() == 5580) {
            print("Did death animation, Checking for loot")
            TILE_DRUID = Npcs.stream().id(Constants.DRUIDS_ID).first().tile()
            TILE_DRUID.valid()
            Condition.wait { GroundItems.stream().id(*Constants.ITEMS_TO_LOOT).at(Constants.TILE_DRUID).isNotEmpty() }
        } else {
            Condition.sleep()
        }
    }
}