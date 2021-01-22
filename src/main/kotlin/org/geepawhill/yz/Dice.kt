package org.geepawhill.yz

import com.google.common.eventbus.EventBus

data class PipChange(val die: Int, val pips: Int)

class Dice(private val bus: EventBus, private val roller: Roller) {
    val pips = arrayOf(UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN)

    fun roll() {
        for (die in 0..4) {
            pips[die] = roller.roll()
            bus.post(PipChange(die, pips[die]))
        }
    }

    fun reset() {
        for (die in 0..4) pips[die] = UNKNOWN
    }

    companion object {
        const val UNKNOWN = 0
    }
}