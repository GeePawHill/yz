package org.geepawhill.yz

import javafx.beans.binding.Bindings
import javafx.beans.property.SimpleIntegerProperty
import java.util.*

class YzModel {
    private val randoms = Random()
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
        for (die in dice) {
            die.pips = randoms.nextInt(6) + 1
        }
        rollsLeftProperty.value = rollsLeftProperty.value - 1
    }

    fun start() {
        rollsLeftProperty.value = 3
    }
}