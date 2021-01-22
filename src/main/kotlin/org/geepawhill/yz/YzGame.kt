package org.geepawhill.yz

import com.google.common.eventbus.EventBus

class YzGame {

    val bus = EventBus()
    private var rollsInRound = 3
    private val dice = Dice(bus, RandomRoller())

    val canRoll: Boolean get() = rollsInRound < 3
    val pips get() = dice.pips.toList()

    fun start() {
        rollsInRound = 0
        dice.reset()
    }

    fun roll() {
        if (!canRoll) throw RuntimeException("Illegal roll!")
        dice.roll()
        rollsInRound += 1
    }
}