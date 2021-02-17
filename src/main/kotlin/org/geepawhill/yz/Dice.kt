package org.geepawhill.yz

import com.google.common.eventbus.EventBus

data class PipChange(val die: Int, val pips: Int)

class Dice(private val bus: EventBus, private val roller: Roller) {
    val pips = arrayOf(UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN)

    fun roll() {
        for (die in 0..4) changePips(die, roller.roll())
    }

    fun reset() {
        for (die in 0..4) changePips(die, UNKNOWN)
    }

    private fun changePips(die: Int, value: Int) {
        pips[die] = value
        bus.post(PipChange(die, value))
    }

    companion object {
        const val UNKNOWN = 0
    }
}