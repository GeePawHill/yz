package org.geepawhill.yz

import com.google.common.eventbus.Subscribe
import javafx.beans.property.SimpleBooleanProperty

class YzModel(private val game: YzGame) {

    val canRoll = SimpleBooleanProperty(false)

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

    fun roll() {
        game.roll()
    }

    fun start() {
        game.start()
    }
}