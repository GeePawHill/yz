package org.geepawhill.yz

import tornadofx.*

class MainView : View() {
    val model = YzModel()

    override val root = pane {
        hbox {
            button("Start") {
                action {
                    model.start()
                }
            }
            button("Roll") {
                enableWhen(model.canRoll)
                action {
                    model.roll()
                }
            }
            label(model.dice[0])
            label(model.dice[1])
            label(model.dice[2])
            label(model.dice[3])
            label(model.dice[4])
        }
    }
}