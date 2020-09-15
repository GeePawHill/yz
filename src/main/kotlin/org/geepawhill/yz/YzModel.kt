package org.geepawhill.yz

import javafx.beans.binding.Bindings
import javafx.beans.property.SimpleIntegerProperty

class YzModel {

    private val game = YzGame()

    private val rollsLeftProperty = SimpleIntegerProperty(0)

    val canRoll = Bindings.notEqual(rollsLeftProperty, 0)

    val dice = arrayOf(
            DieModel(),
            DieModel(),
            DieModel(),
            DieModel(),
            DieModel()
    )

    fun roll() {
        if (!canRoll.value) throw RuntimeException("Illegal roll called!")
        game.dice.roll()
        for (die in 0..4) dice[die].pips = game.dice.pips[die]
        rollsLeftProperty.value = rollsLeftProperty.value - 1
    }

    fun start() {
        rollsLeftProperty.value = 3
    }
}