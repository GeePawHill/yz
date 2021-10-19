package org.geepawhill.yz

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameModelTest {
    val game = YzGame()
    val model = GameModel(game)


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
        assertThat(model.players[0].name).isEqualTo("GeePaw")
        assertThat(model.players[1].name).isEqualTo("Molly")
        assertThat(model.players[2].name).isEqualTo("Wally")
    }
}