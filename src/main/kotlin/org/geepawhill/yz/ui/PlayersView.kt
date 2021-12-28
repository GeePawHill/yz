package org.geepawhill.yz.ui

import javafx.beans.InvalidationListener
import tornadofx.*

class PlayersView(val model: GameModel) : View() {
    val playerViews = hbox { }
    override val root = playerViews

    init {
        val playersListener = InvalidationListener {
            playerViews.clear()
            with(playerViews) {
                for (player in model.players) {
                    this += PlayerView(player)
                }
            }
        }
        model.players.addListener(playersListener)
    }
}
