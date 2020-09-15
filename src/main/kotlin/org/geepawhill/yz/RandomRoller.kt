package org.geepawhill.yz

import java.util.*

class RandomRoller : Roller {
    val randoms = Random()
    
    override fun roll(): Int = randoms.nextInt(6) + 1
}