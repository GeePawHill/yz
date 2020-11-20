package org.geepawhill.yz

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class YzGameTest {
    val game = YzGame()

    @Test
    fun `can't roll dice at start`() {
        assertThat(game.canRoll).isFalse()
    }

    @Test
    fun `throws on unallowed roll`() {
        assertThrows<RuntimeException> { game.roll() }
    }

    @Test
    fun `can roll after start`() {
        game.start()
        assertThat(game.canRoll).isTrue()
    }

    @Test
    fun `three rolls allowed without start`() {
        game.start()
        game.roll()
        game.roll()
        game.roll()
        assertThat(game.canRoll).isFalse()
    }

    @Test
    fun `rolls change the pips`() {
        game.start()
        game.roll()
        for (pips in game.pips) {
            assertThat(pips).isNotEqualTo(0)
        }
    }

    @Test
    fun `start after three rolls allows roll`() {
        game.start()
        game.roll()
        game.roll()
        game.roll()
        game.start()
        assertThat(game.canRoll).isTrue()
    }
}