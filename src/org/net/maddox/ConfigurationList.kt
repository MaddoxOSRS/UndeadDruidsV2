package org.net.maddox

class ConfigurationList(
    val foodName: String,
    val foodAmount: Int
)

object Configs {
    var useRanged: Boolean = false
    var useRigour: Boolean = false
    var usePiety: Boolean = false
    var usefood: Boolean = false
    var foodItemArrays: Array<String>? = null
}