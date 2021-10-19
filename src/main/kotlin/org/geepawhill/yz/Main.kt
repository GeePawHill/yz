package org.geepawhill.yz

import tornadofx.App
import tornadofx.launch

class Main : App(YzView::class) {
    override fun init() {
        println("Starting Main")
        super.init()
    }
}

class Making : App(MakingView::class) {
    override fun init() {
        println("Starting Making")
        super.init()
    }
}

fun main(args: Array<String>) {
    if (args.contains("--making")) launch<Making>(args)
    else launch<Main>(args)
}
