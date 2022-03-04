package extensions

import org.powbot.api.rt4.Equipment

fun hasammo(): Boolean{
    return Equipment.itemAt(Equipment.Slot.QUIVER).id() != Constants.RuneArrowID || Equipment.itemAt(Equipment.Slot.QUIVER).id() != Constants.RuneArrowID
}