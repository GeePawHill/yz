package org.geepawhill.yz.ui

import org.geepawhill.yz.event.PipChange
import org.geepawhill.yz.making.MakingModel
import tornadofx.*

class MakingView : View() {

    val gameView = GameView()
    val gameModel = gameView.model
    val bus = gameModel.game.bus

    val makingModel = MakingModel(bus)

    override val root = borderpane {
        top = toolbar {
            button("Tool") {
                action {
                    bus.post(PipChange(2, 3))
                }
            }
        }
        center = gameView.root
        right = listview(makingModel.events)
    }
}