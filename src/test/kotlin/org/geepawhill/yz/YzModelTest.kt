package org.geepawhill.yz

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class YzModelTest {
    val game = YzGame()
    val model = YzModel(game)


    @Test
    fun `handles pips change events`() {
        game.bus.post(PipChange(4, 6))
        assertThat(model.dice[4].pips).isEqualTo(6)
    }

    @Test
    fun `updates pips from game`() {
        game.start()
        game.roll()
        model.update()
        for (die in model.dice) {
            assertThat(die.pips).isNotEqualTo(Dice.UNKNOWN)
        }
    }

    @Test
    fun `updates canRoll from game`() {
        game.start()
        model.update()
        assertThat(model.canRoll.value).isTrue()
    }
}