package org.geepawhill.yz

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.yz.Dice.Companion.UNKNOWN
import org.junit.jupiter.api.Test

class TestingRoller(vararg pending: Int) : Roller {
    private val pending = pending.toMutableList()

    override fun roll(): Int {
        return when (pending.isNotEmpty()) {
            true -> pending.removeAt(0)
            false -> 1
        }
    }
}

class DiceTest {
    val dice = Dice(TestingRoller(5, 4, 3, 2, 1))

    @Test
    fun `dice start out as unknowns`() {
        dice.pips.forEach { assertThat(it).isEqualTo(UNKNOWN) }
    }

    @Test
    fun `dice change during a roll`() {
        dice.roll()
        assertThat(dice.pips).containsExactly(5, 4, 3, 2, 1)
    }

}