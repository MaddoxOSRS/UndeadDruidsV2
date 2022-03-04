package extensions

import org.net.maddox.Constants
import org.powbot.api.rt4.Equipment

fun hasammo(): Boolean {
    return Equipment.itemAt(Equipment.Slot.QUIVER)
        .id() != Constants.RuneArrowID || Equipment.itemAt(Equipment.Slot.QUIVER).id() != Constants.RuneArrowID
}