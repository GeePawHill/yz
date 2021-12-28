package org.geepawhill.yz.game

import javafx.beans.property.SimpleBooleanProperty

class PlayerModel(val name: String) {
    val isCurrent = SimpleBooleanProperty(false)
}