package org.geepawhill.yz

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class YzModelTest {
    val model = YzModel()

    @Test
    fun `can't roll dice at start`() {
        assertThat(model.canRoll.value).isFalse()
    }

    @Test
    fun `can roll after start`() {
        model.start()
        assertThat(model.canRoll.value).isTrue()
    }

    @Test
    fun `rolls change the dice properties`() {
        model.start()
        model.roll()
        for (die in model.dice) {
            assertThat(die.value).isNotEqualTo(0)
        }
    }

    @Test
    fun `throws on unallowed roll`() {
        assertThrows<RuntimeException> { model.roll() }
    }

    @Test
    fun `three rolls allowed without start`() {
        model.start()
        model.roll()
        model.roll()
        model.roll()
        assertThat(model.canRoll.value).isFalse()
    }

    @Test
    fun `start after three rolls allows roll`() {
        model.start()
        model.roll()
        model.roll()
        model.roll()
        model.start()
        assertThat(model.canRoll.value).isTrue()
    }
}