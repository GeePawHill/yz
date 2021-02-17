package org.geepawhill.yz

import com.google.common.eventbus.EventBus

data class CanRollChange(val canRoll: Boolean)

class YzGame {

    val bus = EventBus()
    private var rollsInRound = 3
    private val dice = Dice(bus, RandomRoller())

    private val canRoll: Boolean get() = rollsInRound < 3

    fun start() {
        rollsInRound = 0
        dice.reset()
        canRollChange(true)
    }

    fun canRollChange(yesOrNo: Boolean) {
        bus.post(CanRollChange(yesOrNo))
    }

    fun roll() {
        if (!canRoll) throw RuntimeException("Illegal roll!")
        dice.roll()
        rollsInRound += 1
        if (rollsInRound == 3) canRollChange(false)
    }
}