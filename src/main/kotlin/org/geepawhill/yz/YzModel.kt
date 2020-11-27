package org.geepawhill.yz

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

    fun roll() {
        game.roll()
        update()
    }

    fun update() {
        for (die in 0..4) dice[die].pips = game.pips[die]
        canRoll.value = game.canRoll
    }

    fun start() {
        game.start()
        update()
    }
}