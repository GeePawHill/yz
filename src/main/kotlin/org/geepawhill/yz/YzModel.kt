package org.geepawhill.yz

import com.google.common.eventbus.Subscribe
import javafx.beans.property.SimpleBooleanProperty

class YzModel(private val game: YzGame) {

    val canRoll = SimpleBooleanProperty(game.canRoll)

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

    fun roll() {
        game.roll()
        update()
    }

    fun update() {
        canRoll.value = game.canRoll
    }

    fun start() {
        game.start()
        update()
    }
}