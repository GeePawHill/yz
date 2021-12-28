package org.geepawhill.yz.ui

import com.google.common.eventbus.Subscribe
import javafx.beans.property.SimpleBooleanProperty
import org.geepawhill.yz.event.CanRollChange
import org.geepawhill.yz.event.CurrentPlayer
import org.geepawhill.yz.event.GameStart
import org.geepawhill.yz.event.PipChange
import org.geepawhill.yz.game.PlayerModel
import org.geepawhill.yz.game.YzGame
import tornadofx.*

class GameModel(val game: YzGame) {

    val canRoll = SimpleBooleanProperty(false)
    val players = observableListOf<PlayerModel>()
    val dice = arrayOf(
        DieModel(),
        DieModel(),
        DieModel(),
        DieModel(),
        DieModel()
    )

    init {
        game.bus.register(this)
    }

    @Subscribe
    fun handlePipChange(event: PipChange) {
        dice[event.die].pips = event.pips
    }

    @Subscribe
    fun handleCanRollChange(event: CanRollChange) {
        canRoll.value = event.canRoll
    }

    @Subscribe
    fun gameStart(event: GameStart) {
        players.clear()
        event.players.forEach {
            players.add(PlayerModel(it))
        }
    }

    @Subscribe
    fun currentPlayer(event: CurrentPlayer) {
        players.withIndex().forEach {
            it.value.isCurrent.value = it.index == event.player
        }
    }

    fun roll() {
        game.roll()
    }

    fun start() {
        game.start()
    }
}