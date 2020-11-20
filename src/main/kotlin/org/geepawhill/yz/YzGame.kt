package org.geepawhill.yz

class YzGame {

    private var rollsInRound = 3
    private val dice = Dice(RandomRoller())

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