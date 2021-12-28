package org.geepawhill.yz.ui

import javafx.stage.Modality
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

    init {
        model.isGameOver.addListener { _, _, newValue ->
            if (newValue) {
                val gameOverView = GameOverView()
                gameOverView.openModal(modality = Modality.APPLICATION_MODAL)
            }
        }
    }
}