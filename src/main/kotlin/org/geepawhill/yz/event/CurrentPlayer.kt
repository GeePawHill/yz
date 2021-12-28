package org.geepawhill.yz.event

data class CurrentPlayer(val playerIndex: Int) : GameEvent {

    companion object {
        const val NO_PLAYER = -1
    }
}