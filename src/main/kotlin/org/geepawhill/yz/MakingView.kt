package org.geepawhill.yz

import tornadofx.View
import tornadofx.borderpane
import tornadofx.button
import tornadofx.toolbar

class MakingView : View() {
    
    override val root = borderpane {
        top = toolbar {
            button("Tool")
        }
        center = GameView().root
    }
}