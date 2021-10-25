package org.geepawhill.yz.making

import com.google.common.eventbus.EventBus
import com.google.common.eventbus.Subscribe
import org.geepawhill.yz.event.GameEvent
import tornadofx.*

class MakingModel(val bus: EventBus) {
    val events = observableListOf<GameEvent>()

    init {
        bus.register(this)
    }

    @Subscribe
    fun receive(event: GameEvent) {
        events.add(event)
    }
}
