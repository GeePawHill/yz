package org.geepawhill.yz.event

data class GameOver(val winnerIndexes: List<Int>) : GameEvent
