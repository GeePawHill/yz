package org.geepawhill.yz.ui

import tornadofx.*

class ScoresView : View() {
    val descriptionsView = DescriptionsView()
    val playersView = PlayersView()
    override val root = hbox {
        this += descriptionsView
        this += playersView
    }
}