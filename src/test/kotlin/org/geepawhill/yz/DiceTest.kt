package org.geepawhill.yz

import com.google.common.eventbus.EventBus
import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.yz.Dice.Companion.UNKNOWN
import org.geepawhill.yz.event.PipChange
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
    val bus = EventBus()
    val dice = Dice(bus, TestingRoller(5, 4, 3, 2, 1))

    val events = EventSink(bus)

    @Test
    fun `dice sends pip change events on roll`() {
        dice.roll()
        assertThat(events).contains(
            PipChange(0, 5),
            PipChange(1, 4),
            PipChange(2, 3),
            PipChange(3, 2),
            PipChange(4, 1)
        )
    }

    @Test
    fun `dice change during a roll`() {
        dice.roll()
        assertThat(dice.pips).containsExactly(5, 4, 3, 2, 1)
    }

    @Test
    fun `dice start out as unknowns`() {
        dice.pips.forEach { assertThat(it).isEqualTo(UNKNOWN) }
    }

    @Test
    fun `dice sends pip change events on reset`() {
        dice.reset()
        assertThat(events).contains(
            PipChange(0, UNKNOWN),
            PipChange(1, UNKNOWN),
            PipChange(2, UNKNOWN),
            PipChange(3, UNKNOWN),
            PipChange(4, UNKNOWN)
        )
    }

    @Test
    fun `reset resets to unknowns`() {
        dice.roll()
        dice.reset()
        dice.pips.forEach { assertThat(it).isEqualTo(UNKNOWN) }
    }


}