package org.geepawhill.yz.making

import com.google.common.eventbus.EventBus
import tornadofx.*

class MakingModel(val bus: EventBus) {
    val events = observableListOf<Any>()
}
