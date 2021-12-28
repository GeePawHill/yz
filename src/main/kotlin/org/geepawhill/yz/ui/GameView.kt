package org.geepawhill.yz.ui

import org.geepawhill.yz.game.YzGame
import tornadofx.*

class GameView : View() {
    val model = GameModel(YzGame())

    override val root = vbox {
        hbox {
            button("Start") {
                action { model.start() }
            }
            button("Roll") {
                enableWhen(model.canRoll)
                action { model.roll() }
            }
            model.dice.forEach {
                imageview {
                    imageProperty().bind(it.imageReadOnly)
                }
                label(it.pipsReadOnly)
            }
        }
    }
}