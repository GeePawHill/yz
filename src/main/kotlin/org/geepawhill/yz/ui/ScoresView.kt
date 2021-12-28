package org.geepawhill.yz.ui

import tornadofx.*

class ScoresView(val model: GameModel) : View() {
    val descriptionsView = DescriptionsView()
    val playersView = PlayersView(model)
    override val root = hbox {
        this += descriptionsView
        this += playersView
    }
}