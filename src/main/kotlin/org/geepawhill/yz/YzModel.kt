package org.geepawhill.yz

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleIntegerProperty

class YzModel {

    private val game = YzGame()

    private val rollsLeftProperty = SimpleIntegerProperty(0)

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

    private fun update() {
        for (die in 0..4) dice[die].pips = game.pips[die]
        canRoll.value = game.canRoll
    }

    fun start() {
        game.start()
        update()
    }
}