package org.geepawhill.yz

import tornadofx.*

class MakingView : View() {

    val gameView = GameView()
    val gameModel = gameView.model
    val bus = gameModel.game.bus

    override val root = borderpane {
        top = toolbar {
            button("Tool") {
                action {
                    bus.post(PipChange(2, 3))
                }
            }
        }
        center = gameView.root
    }
}