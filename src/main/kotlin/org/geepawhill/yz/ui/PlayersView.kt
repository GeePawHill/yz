package org.geepawhill.yz.ui

import tornadofx.*

class PlayersView : View() {
    override val root = hbox {
        label("PlayersView") {
            minHeight = Layout.SCORE_HEIGHT
            minWidth = Layout.SCORE_WIDTH
        }
    }
}
