package org.net.maddox

import org.powbot.api.Area
import org.powbot.api.Tile

object Constants {
    var HOSIDIOUS_BANK = Tile(1748, 3599, 0)
    var FORTHOS_ENTRANCE = Tile(1671, 3569, 0)
    var DRUID_AREA = Area(Tile(1803, 9957, 0), Tile(1797, 9951, 0))
    var FORTHOS_DUNGEON = Area(Tile(1791, 9982, 0), Tile(1822, 9916, 0))
    var HOSIDIOUS_BANK_AREA = Area(Tile(1745, 3601, 0), Tile(1752, 3594, 0))
    var DRUID_ATTACK_AREA = Area(Tile(1795, 9957, 0), Tile(1806, 9934, 0))
    var OUTSIDE_HOUSE = Area(Tile(1737, 3605, 0), Tile(1763, 3509, 0))
    var FORTHOS_STAIRCASE = Tile(1669, 3567, 0)
    var NORTHERN_TILE = Tile(1800, 9945, 0)
    const val FORTHOSENTRANCE = 34865;
    val ALTARS = 34900
    val ITEMS_TO_LOOT = arrayOf(995, 23499, 1397, 1399, 207).toIntArray()
    const val BoneBoltsID = 8882;
    const val RuneArrowID = 892;
    const val DRUIDS_ID = 2145
    const val ITEM_HOUSE_TELEPORT = "Teleport to house"
}