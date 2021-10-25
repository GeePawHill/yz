package org.geepawhill.yz

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.yz.event.CanRollChange
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class YzGameTest {
    val game = YzGame()
    val sink = EventSink(game.bus)

    @Test
    fun `sends canRoll true on start`() {
        game.start()
        assertThat(sink.last()).isEqualTo(CanRollChange(true))
    }

    @Test
    fun `sends canRoll false after three rolls`() {
        game.start()
        game.roll()
        game.roll()
        game.roll()
        assertThat(sink.last()).isEqualTo(CanRollChange(false))
    }

    @Test
    fun `throws on unallowed roll`() {
        assertThrows<RuntimeException> { game.roll() }
    }
}