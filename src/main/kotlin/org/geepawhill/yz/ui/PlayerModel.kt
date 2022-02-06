package org.geepawhill.yz.ui

import javafx.beans.property.SimpleBooleanProperty

class PlayerModel(val name: String) {
    val isCurrent = SimpleBooleanProperty(false)
}