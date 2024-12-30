package fi.viware.aoc2024.day10

import org.junit.Assert.*
import org.junit.Test

class Day10Test(){

    @Test
    fun puzz1Tests(){

        var day = Day10("src/main/res/input_test1")
        var s = day.topoMap.inputLines.toString()
        println("$s")
        assertEquals("[0123, 1234, 8765, 9876]", s)

        var i = day.topoMap.findRoute(Pair(0, 0), Pair(3, 0))
        println("$i")
        assertEquals(1, i)

        day = Day10("src/main/res/input_test")
        var lpii = day.topoMap.findStarts()
        println("$lpii")
        assertEquals("[(0, 2), (0, 4), (2, 4), (4, 6), (5, 2), (5, 5), (6, 0), (6, 6), (7, 1)]", lpii.toString())

        lpii = day.topoMap.findEnds()
        println("$lpii")
        assertEquals("[(0, 1), (2, 5), (3, 0), (3, 4), (4, 5), (5, 4), (6, 4)]", lpii.toString())

        day = Day10("src/main/res/input_test2")
        i = day.topoMap.countScores()
        println("$i")
        assertEquals(4, i)

        day = Day10("src/main/res/input_test3")
        i = day.topoMap.findRoute(Pair(0, 1), Pair(0, 4))
        println("$i")
        assertEquals(0, i)
        i = day.topoMap.countScores()
        println("$i")
        assertEquals(3, i)

        day = Day10("src/main/res/input_test")
        i = day.topoMap.countScores()
        println("$i")
        assertEquals(36, i)

    }
}