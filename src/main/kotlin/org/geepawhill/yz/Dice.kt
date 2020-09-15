package org.geepawhill.yz

class Dice(private val roller: Roller) {
    val pips = arrayOf(UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN)

    fun roll() {
        for (die in 0..4) pips[die] = roller.roll()
    }

    companion object {
        const val UNKNOWN = 0
    }
}