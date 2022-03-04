package org.net.maddox.extensions

import org.powbot.api.rt4.GrandExchange
import org.powbot.api.rt4.GroundItem
import org.powbot.api.rt4.GroundItems
import org.powbot.api.rt4.GroundItems.stream
import org.powbot.api.rt4.stream.locatable.interactive.GroundItemStream

fun GroundItems.grounditemPrice(itemID: IntArray): GroundItem {
    return stream().id(*itemID).first()
}

fun GroundItems.lootItem(): GroundItemStream {
    return stream().filtered { GrandExchange.grounditemPrice2(it.id()) >= 1000 }
    // return stream().GrandExchange.grounditemPrice2(itemID) >= 1000).within(7).isNotEmpty()
}

fun GroundItem.lootItem2(): GroundItemStream {
    return stream().filtered { GrandExchange.grounditemPrice2(it.id()) >= 1000 }
    // return stream().GrandExchange.grounditemPrice2(itemID) >= 1000).within(7).isNotEmpty()
}

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