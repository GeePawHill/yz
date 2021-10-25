package org.geepawhill.yz

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.yz.ui.DieModel
import org.junit.jupiter.api.Test

class DieModelTest {
    val model = DieModel()

    @Test
    fun `starts with Unknown`() {
        assertThat(model.pips).isEqualTo(DieModel.UNKNOWN)
        assertThat(model.imageReadOnly.value.url).endsWith("question.png")
    }

    @Test
    fun `legal value changes on set`() {
        model.pips = 5
        assertThat(model.pips).isEqualTo(5)
        assertThat(model.imageReadOnly.value.url).endsWith("five.png")
    }

    @Test
    fun `illegal value is UNKNOWN`() {
        model.pips = -7
        assertThat(model.pips).isEqualTo(DieModel.UNKNOWN)
    }

}