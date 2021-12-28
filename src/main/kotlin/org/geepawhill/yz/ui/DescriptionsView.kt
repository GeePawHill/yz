package org.geepawhill.yz.ui

import tornadofx.*

class DescriptionsView : View() {
    override val root = vbox {
        label("Description") {
            minHeight = Layout.SCORE_HEIGHT
            minWidth = Layout.SCORE_WIDTH
        }
    }
}
