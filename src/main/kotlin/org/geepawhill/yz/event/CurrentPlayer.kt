package org.geepawhill.yz.event

data class CurrentPlayer(val player: Int) : GameEvent {

    companion object {
        const val NO_PLAYER = -1
    }
}