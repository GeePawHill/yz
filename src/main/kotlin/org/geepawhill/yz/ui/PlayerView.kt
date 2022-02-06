package org.geepawhill.yz.ui

import tornadofx.*

class PlayerView(playerModel: PlayerModel) : Fragment() {
    override val root = vbox {
        enableWhen(playerModel.isCurrent)
        label(playerModel.name) {
            minHeight = Layout.SCORE_HEIGHT
            minWidth = Layout.SCORE_WIDTH
        }
        button("Score!")
    }
}