package org.geepawhill.yz.ui

import org.geepawhill.yz.game.PlayerModel
import tornadofx.*

class PlayerView(playerModel: PlayerModel) : Fragment() {
    override val root = vbox {
        label(playerModel.name) {
            minHeight = Layout.SCORE_HEIGHT
            minWidth = Layout.SCORE_WIDTH
        }
    }
}