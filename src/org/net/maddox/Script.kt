package org.net.maddox

import org.net.maddox.branch.IsBankOpened
import org.powbot.api.Color
import org.powbot.api.rt4.walking.model.Skill
import org.powbot.api.script.ScriptCategory
import org.powbot.api.script.ScriptManifest
import org.powbot.api.script.paint.Paint
import org.powbot.api.script.paint.PaintBuilder
import org.powbot.api.script.tree.TreeComponent
import org.powbot.api.script.tree.TreeScript
import org.powbot.mobile.service.ScriptUploader

@ScriptManifest(
    name = "UndeadDruids",
    description = "Kills Undead druids W/Bank Support",
    version = "0.0.1",
    category = ScriptCategory.MoneyMaking,
    author = "Maddox"
)


class Script : TreeScript() {
    override val rootComponent: TreeComponent<*> by lazy {
        IsBankOpened(this)

    }

    override fun onStart() {
        super.onStart()
        addPaint()
    }

    private fun addPaint() {
        val p: Paint = PaintBuilder.newBuilder()
            .addString("Last leaf:") { lastLeaf.name }
            .trackSkill(Skill.Ranged)
            .trackInventoryItems(*Constants.ITEMS_TO_LOOT)
            .backgroundColor(Color.argb(255, 117, 124, 168))
            .build()
        addPaint(p)
    }
}

fun main(args: Array<String>) {
    ScriptUploader().uploadAndStart("UndeadDruids", "cmepkurday", "127.0.0.1:5585", true, false)
}