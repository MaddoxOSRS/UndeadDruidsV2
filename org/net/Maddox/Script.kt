import Branch.IsBankOpened
import org.powbot.api.Color
import org.powbot.api.Notifications
import org.powbot.api.rt4.walking.model.Skill
import org.powbot.api.script.OptionType
import org.powbot.api.script.ScriptCategory
import org.powbot.api.script.ScriptConfiguration
import org.powbot.api.script.ScriptManifest
import org.powbot.api.script.paint.Paint
import org.powbot.api.script.paint.PaintBuilder
import org.powbot.api.script.tree.TreeComponent
import org.powbot.api.script.tree.TreeScript
import org.powbot.mobile.script.ScriptManager
import org.powbot.mobile.service.ScriptUploader

@ScriptManifest(
    name = "UndeadDruids",
    description = "Kills Undead druids W/Bank Support",
    version = "0.0.1",
    category = ScriptCategory.MoneyMaking,
    author = "Maddox"
)



class Script : TreeScript(){
    override val rootComponent: TreeComponent<*> by lazy {
    IsBankOpened(this)
}
   // lateinit var configuration: Configs
    override fun onStart(){
        super.onStart()
        //extractConfiguration()
        addPaint()
    }
    /**
     *  This method extracts the configuration from the GUI which is presented via the class annotations.
     */
 /*   private fun extractConfiguration() {
        val lootValue = getOption<Int>("Grab Items above GP Value:")

        configuration = Configs(lootValue)
    }*/

    private fun addPaint(){
        val p: Paint = PaintBuilder.newBuilder()
            .addString("Last leaf:"){lastLeaf.name}
            .trackSkill(Skill.Ranged)
            .backgroundColor(Color.argb(255,117,124,168))
            .build()
        addPaint(p)
    }
}

fun main(args: Array<String>) {
    ScriptUploader().uploadAndStart("UndeadDruids", "bact", "127.0.0.1:5575", true, false)
}