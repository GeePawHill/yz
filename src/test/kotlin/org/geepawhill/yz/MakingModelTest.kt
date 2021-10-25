package org.geepawhill.yz

import com.google.common.eventbus.EventBus
import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.yz.event.PipChange
import org.geepawhill.yz.making.MakingModel
import org.junit.jupiter.api.Test

class MakingModelTest {

    val bus = EventBus()
    val model = MakingModel(bus)

    @Test
    fun `catches pipchange events`() {
        bus.post(PipChange(0, 0))
        assertThat(model.events).contains(PipChange(0, 0))
    }
}