package org.geepawhill.yz

import javafx.embed.swing.JFXPanel
import java.util.concurrent.CountDownLatch
import javax.swing.SwingUtilities

class Jfx {

    companion object {
        private var javaFxRunning: Boolean = false

        fun required() {
            try {
                runJavaFx()
            } catch (e: InterruptedException) {
                throw RuntimeException(e)
            }
        }

        @Throws(InterruptedException::class)
        private fun runJavaFx() {
            if (javaFxRunning) return
            val latch = CountDownLatch(1)
            SwingUtilities.invokeLater {
                JFXPanel()
                latch.countDown()
            }

            latch.await()
            javaFxRunning = true
        }
    }
}