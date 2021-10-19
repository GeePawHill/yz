package org.geepawhill.yz

import tornadofx.App
import tornadofx.launch

class Main : App(GameView::class) {
}

class Making : App(MakingView::class) {
}

fun main(args: Array<String>) {
    if (args.contains("--making")) launch<Making>(args)
    else launch<Main>(args)
}
