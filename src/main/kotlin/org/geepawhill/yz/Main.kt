package org.geepawhill.yz

import tornadofx.App
import tornadofx.launch

class Main : App(YzView::class) {
}

fun main(args: Array<String>) {
    println("Called.")
    launch<Main>(args)
}
