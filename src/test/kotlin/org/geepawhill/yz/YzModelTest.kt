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
    fun `handles canRoll change events`() {
        game.bus.post(CanRollChange(true))
        assertThat(model.canRoll.value).isEqualTo(true)
    }

    @Test
    fun `resets player list on game start`() {
        game.bus.post(GameStart(listOf("GeePaw", "Molly", "Wally")))
        assertThat(model.players.size).isEqualTo(3)
        assertThat(model.player[0].name).isEqualTo("GeePaw")
        assertThat(model.player[1].name).isEqualTo("Molly")
        assertThat(model.player[2].name).isEqualTo("Wally")
    }
}