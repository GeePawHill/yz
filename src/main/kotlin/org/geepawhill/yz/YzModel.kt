package org.geepawhill.yz

import javafx.beans.binding.Bindings
import javafx.beans.property.SimpleIntegerProperty
import java.util.*

class YzModel {
    private val randoms = Random()
    private val rollsLeftProperty = SimpleIntegerProperty(0)

    val canRoll = Bindings.notEqual(rollsLeftProperty, 0)

    val dice = listOf(
            SimpleIntegerProperty(1),
            SimpleIntegerProperty(2),
            SimpleIntegerProperty(3),
            SimpleIntegerProperty(4),
            SimpleIntegerProperty(5)
    )

    fun roll() {
        for (die in dice) {
            die.value = randoms.nextInt(6) + 1
        }
        rollsLeftProperty.value = rollsLeftProperty.value - 1
    }

    fun start() {
        rollsLeftProperty.value = 3
    }
}