package org.net.maddox.extensions

import org.powbot.api.rt4.GrandExchange
import org.powbot.api.rt4.GroundItems


fun GrandExchange.grounditemPrice2(itemID: Int): Int {
    val itemtoPrice = GroundItems.stream().id(itemID).first()
    return if (itemtoPrice.noted()) {
        getItemPrice(GroundItems.stream().id(itemID).first().id() - 1) * GroundItems.stream().id(itemID).first()
            .stackSize()
    } else {
        getItemPrice(GroundItems.stream().id(itemID).first().id()) * getItemPrice(
            GroundItems.stream().id(itemID).first().stackSize()
        )
    }
}