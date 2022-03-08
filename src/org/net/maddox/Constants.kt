package org.net.maddox

import org.powbot.api.Area
import org.powbot.api.Tile

object Constants {
    val HOSIDIOUS_BANK = Tile(1748, 3599, 0)
    val DRUID_AREA = Area(Tile(1803, 9957, 0), Tile(1797, 9951, 0))
    val FORTHOS_DUNGEON = Area(Tile(1791, 9982, 0), Tile(1822, 9916, 0))
    val DRUID_ATTACK_AREA = Area(Tile(1795, 9957, 0), Tile(1806, 9934, 0))
    val OUTSIDE_HOUSE = Area(Tile(1737, 3605, 0), Tile(1763, 3509, 0))
    val FORTHOS_STAIRCASE = Tile(1669, 3567, 0)
    val FORTHOS_ENTRANCE = Area(Tile(1669, 3569, 0), Tile(1672, 3564, 0))
    val NORTHERN_TILE = Tile(1800, 9945, 0)
    const val FORTHOSENTRANCE = 34865
    val ALTARS = 34900
    val ITEMS_TO_LOOT =
        arrayOf(995, 23499, 1397, 1399, 207, 560, 564, 565, 561, 563, 4698, 5295, 5300, 3138, 245, 239).toIntArray()
    const val BoneBoltsID = 8882
    const val RuneArrowID = 892
    const val DRUIDS_ID = 2145
    var TILE_DRUID = Tile(-1, -1, -1)
    const val ITEM_HOUSE_TELEPORT = "Teleport to house"
}