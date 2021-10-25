package org.geepawhill.yz

import org.geepawhill.yz.ui.GameView
import org.geepawhill.yz.ui.MakingView
import tornadofx.*

class Main : App(GameView::class) {
}

class Making : App(MakingView::class) {
}

fun main(args: Array<String>) {
    if (args.contains("--making")) launch<Making>(args)
    else launch<Main>(args)
}
