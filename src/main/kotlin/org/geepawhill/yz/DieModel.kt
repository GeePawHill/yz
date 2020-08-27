package org.geepawhill.yz

import javafx.beans.property.ReadOnlyIntegerWrapper
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.scene.image.Image

class DieModel {
    private val pipsProperty = ReadOnlyIntegerWrapper(UNKNOWN)
    val pipsReadOnly = pipsProperty.readOnlyProperty

    private val imageProperty = ReadOnlyObjectWrapper(images[0])
    val imageReadOnly = imageProperty.readOnlyProperty

    var pips: Int
        get() = pipsProperty.value
        set(value) {
            if (value in 0..6) {
                imageProperty.set(images[value])
                pipsProperty.set(value)
            } else {
                imageProperty.set(images[UNKNOWN])
                pipsProperty.set(UNKNOWN)
            }
        }

    companion object {
        init {
            Jfx.required()
        }

        val images = arrayOf(
                Image("org/geepawhill/yz/dice/question.png", 100.0, 100.0, true, true),
                Image("org/geepawhill/yz/dice/one.png", 100.0, 100.0, true, true),
                Image("org/geepawhill/yz/dice/two.png", 100.0, 100.0, true, true),
                Image("org/geepawhill/yz/dice/three.png", 100.0, 100.0, true, true),
                Image("org/geepawhill/yz/dice/four.png", 100.0, 100.0, true, true),
                Image("org/geepawhill/yz/dice/five.png", 100.0, 100.0, true, true),
                Image("org/geepawhill/yz/dice/six.png", 100.0, 100.0, true, true)
        )

        const val UNKNOWN = 0
    }
}