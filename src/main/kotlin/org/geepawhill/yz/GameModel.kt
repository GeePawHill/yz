package org.geepawhill.yz

import com.google.common.eventbus.Subscribe
import javafx.beans.property.SimpleBooleanProperty
import org.geepawhill.yz.event.CanRollChange
import org.geepawhill.yz.event.GameStart
import org.geepawhill.yz.event.PipChange
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

    fun roll() {
        game.roll()
    }

    fun start() {
        game.start()
    }
}