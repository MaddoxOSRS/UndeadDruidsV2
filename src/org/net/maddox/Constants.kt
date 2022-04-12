package org.net.maddox

import org.powbot.api.Area
import org.powbot.api.Tile

object Constants {
    val HOSIDIOUS_BANK = Area(Tile(1745, 3601, 0), Tile(1752, 3594, 0))
    val DRUID_AREA = Area(Tile(1803, 9957, 0), Tile(1797, 9951, 0))
    val FORTHOS_DUNGEON = Area(Tile(1791, 9982, 0), Tile(1822, 9916, 0))
    val DRUID_ATTACK_AREA = Area(Tile(1795, 9957, 0), Tile(1806, 9934, 0))
    val OUTSIDE_HOUSE = Area(Tile(1737, 3605, 0), Tile(1763, 3509, 0))
    val FORTHOS_ENTRANCE = Area(Tile(1669, 3569, 0), Tile(1672, 3564, 0))
    val ITEMS_TO_LOOT =
        arrayOf(
            995, //coins
            23499, //Grubby key
            1397, //Air battlestaff
            1399, //Earth battlestaff
            207, //Grimy Ranarr
            560, //Death rune
            564, //Cosmic rune
            565, //Blood rune
            561, //Nature rune
            563, //Law rune
            4698, //Mud rune
            5295, //Ranarr seed
            5300, //Snapdragon seed
            3139, //Potato cactus
            246, //Wine of Zamorak
            240, //White berries
            213 //Grimy kwuarm
        ).toIntArray()
    val ITEMS_TO_TRACK =
        arrayOf(
            23499, //Grubby key
            1397, //Air battlestaff
            1399, //Earth battlestaff
            207, //Grimy Ranarr
            560, //Death rune
            564, //Cosmic rune
            565, //Blood rune
            561 //Nature rune
        ).toIntArray()
    const val FORTHOSENTRANCE = 34865
    const val ID_ALTARS = 34900
    const val ITEM_HOUSE_TELEPORT = "Teleport to house"
    const val ID_BONEBOLTS = 8882
    const val ID_RUNEARROWS = 892
    const val DRUIDS_ID = 2145


    var TILE_DRUID = Tile(-1, -1, -1)
}