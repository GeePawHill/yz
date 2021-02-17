package org.geepawhill.yz

import com.google.common.eventbus.EventBus
import com.google.common.eventbus.Subscribe

class EventSink(bus: EventBus, private val base: MutableList<Any> = mutableListOf()) : List<Any> by base {

    init {
        bus.register(this)
    }

    @Subscribe
    fun handleAny(any: Any) {
        base += any
    }
}