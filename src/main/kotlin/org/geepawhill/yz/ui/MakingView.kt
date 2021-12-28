package org.geepawhill.yz.ui

import org.geepawhill.yz.event.CurrentPlayer
import org.geepawhill.yz.event.GameOver
import org.geepawhill.yz.event.GameStart
import org.geepawhill.yz.making.MakingModel
import tornadofx.*

class MakingView : View() {

    val gameView = GameView()
    val gameModel = gameView.model
    val bus = gameModel.game.bus

    val scoresView = ScoresView(gameModel)

    val makingModel = MakingModel(bus)

    override val root = borderpane {
        top = toolbar {
            button("Start 1") {
                action {
                    bus.post(GameStart(listOf("Molly", "Wally", "GeePaw")))
                }
            }
            button("Start 2") {
                action {
                    bus.post(GameStart(listOf("GeePaw", "Molly")))
                }
            }
            button("Current 0") {
                action {
                    bus.post(CurrentPlayer(0))
                }
            }
            button("Current 1") {
                action {
                    bus.post(CurrentPlayer(1))
                }
            }
            button("GameOver") {
                action {
                    bus.post(GameOver(emptyList()))
                }
            }
        }
        center = gameView.root
        bottom = scoresView.root
        right = listview(makingModel.events)
    }
}