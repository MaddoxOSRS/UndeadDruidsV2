package org.net.maddox

import com.google.common.eventbus.Subscribe
import org.net.maddox.branch.IsBankOpened
import org.powbot.api.Color
import org.powbot.api.event.InventoryChangeEvent
import org.powbot.api.rt4.walking.model.Skill
import org.powbot.api.script.*
import org.powbot.api.script.paint.Paint
import org.powbot.api.script.paint.PaintBuilder
import org.powbot.api.script.tree.TreeComponent
import org.powbot.api.script.tree.TreeScript


@ScriptManifest(
    name = "UndeadDruids",
    description = "Kills Undead druids W/Bank Support",
    version = "0.0.1",
    category = ScriptCategory.MoneyMaking,
    author = "Maddox"
)
@ScriptConfiguration.List(
    [
        ScriptConfiguration(
            name = "Use Range?",
            description = "Will you be using Ranged?",
            optionType = OptionType.BOOLEAN
        ),
        ScriptConfiguration(
            name = "Use Rigour?",
            description = "Will you be using Rigour?",
            optionType = OptionType.BOOLEAN
        ),
        ScriptConfiguration(
            name = "Use Piety?",
            description = "Will you be using Piety?",
            optionType = OptionType.BOOLEAN
        ),
        ScriptConfiguration(
            name = "Use Food",
            description = "Do you want to eat food?",
            optionType = OptionType.BOOLEAN
        ),
        ScriptConfiguration(
            name = "Food List",
            description = "Enter the name of the food you would like to use.",
            optionType = OptionType.STRING,
            "",
            ["",
                "Lobster", "Bass", "Swordfish",
                "Potato with cheese", "Monkfish",
                "Cooked karambwan", "Shark", "Sea turtle",
                "Manta ray", "Tuna potato", "Dark crab",
                "Anglerfish"],
            visible = false
        ),
        ScriptConfiguration(
            name = "Food Amount",
            description = "Enter the amount of food you would like to take",
            optionType = OptionType.INTEGER,
            "",
            visible = false
        ),
    ]
)

class Script : TreeScript() {
    override val rootComponent: TreeComponent<*> by lazy {
        IsBankOpened(this)

    }
    lateinit var configuration: ConfigurationList

    override fun onStart() {
        val food = getOption<String>("Food List")
        val foodamt = getOption<Int>("Food Amount")
        Configs.useRanged = getOption("Use Range?")
        Configs.useRigour = getOption("Use Rigour?")
        Configs.usePiety = getOption("Use Piety?")
        Configs.usefood = getOption("Use Food")
        configuration = ConfigurationList(
            food, foodamt
        )
        if (Configs.usefood) {
            val tempList: String = getOption("Food List")
            Configs.foodItemArrays = tempList.split(",").toTypedArray()
        }
        addPaint()
    }

    private fun addPaint() {
        val p: Paint = PaintBuilder.newBuilder()
            .addString("Last leaf:") { lastLeaf.name }
            .trackSkill(Skill.Ranged)
            .trackSkill(Skill.Attack)
            .trackSkill(Skill.Strength)
            .trackSkill(Skill.Defence)
            .trackSkill(Skill.Hitpoints)
            .trackInventoryItems(*Constants.ITEMS_TO_TRACK)
            .backgroundColor(Color.argb(255, 117, 124, 168))
            .build()
        addPaint(p)
    }

    @ValueChanged(keyName = "Use Food")
    fun useFoodValue(valueChanged: Boolean) {
        updateVisibility("Food List", valueChanged)
        updateVisibility("Food Amount", valueChanged)
    }

    @Subscribe
    fun inventoryChanged(inventoryChangeEvent: InventoryChangeEvent) {

    }
}


fun main(args: Array<String>) {
    Script().startScript()
}