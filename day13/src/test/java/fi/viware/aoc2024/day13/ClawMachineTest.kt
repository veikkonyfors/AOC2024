package fi.viware.aoc2024.day13

import org.junit.Assert.*
import org.junit.Test

class ClawMachineTest() {

    @Test
    fun puzz1Test() {

        var day = Day13("src/main/res/input_test")
        var s = day.inputLines.joinToString("\n") { it }
        println("$s")
        assertEquals("Button A: X+94, Y+34\nButton B: X+22, Y+67\nPrize: X=8400, Y=5400\n\nButton A: X+26, Y+66\nButton B: X+67, Y+21\nPrize: X=12748, Y=12176\n\nButton A: X+17, Y+86\nButton B: X+84, Y+37\nPrize: X=7870, Y=6450\n\nButton A: X+69, Y+23\nButton B: X+27, Y+71\nPrize: X=18641, Y=10279", s)

        s = day.clawMachines.joinToString(separator = "\n") {
            "" + it.aMoves + ", " + it.bMoves + ", " + it.prizeXY
        }
        println("$s")
        assertEquals("(94, 34), (22, 67), (8400, 5400)\n(26, 66), (67, 21), (12748, 12176)\n(17, 86), (84, 37), (7870, 6450)\n(69, 23), (27, 71), (18641, 10279)", s)

        var i = day.clawMachines[0].bMax()
        println("$i")
        assertEquals(80, i)

        var cm = day.clawMachines[0]
        var p = cm.cheapestPushes(cm.bMax())
        println("$p")
        assertEquals("(80, 40)", p.toString())

        cm = day.clawMachines[1]
        p = cm.cheapestPushes(cm.bMax())
        println("$p")
        assertEquals("(0, 0)", p.toString())

        cm = day.clawMachines[2]
        p = cm.cheapestPushes(cm.bMax())
        println("$p")
        assertEquals("(38, 86)", p.toString())

        cm = day.clawMachines[0]
        i = cm.cost(cm.cheapestPushes(cm.bMax()))
        println("$i")
        assertEquals(i, 280)

        cm = day.clawMachines[1]
        i = cm.cost(cm.cheapestPushes(cm.bMax()))
        println("$i")
        assertEquals(i, 0)

        cm = day.clawMachines[2]
        i = cm.cost(cm.cheapestPushes(cm.bMax()))
        println("$i")
        assertEquals(200, i)

        i = 0
        day.clawMachines.forEach {
            i += it.cost(it.cheapestPushes(it.bMax()))
        }
        println("$i")
        assertEquals(480, i)

        day = Day13("src/main/res/input")
        i = 0
        day.clawMachines.forEach {
            i += it.cost(it.cheapestPushes(it.bMax()))
        }
        println("$i")
        assertEquals(480, i)
    }
}