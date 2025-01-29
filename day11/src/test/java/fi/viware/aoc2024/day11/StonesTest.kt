package fi.viware.aoc2024.day11

import org.junit.Assert.*
import org.junit.Test


class StonesTest(){

    @Test
    fun puzz1Tests(){
        var day = Day11("src/main/res/input_test")
        var s = day.stones.toString()
        println("$s")
        assertEquals("[125, 17]", s)

        day.stones.blink()
        s = day.stones.toString()
        println("$s")
        assertEquals("[253000, 1, 7]", s)

        day.stones.blink()
        s = day.stones.toString()
        println("$s")
        assertEquals("[253, 0, 2024, 14168]", s)

        day.stones.blink()
        s = day.stones.toString()
        println("$s")
        assertEquals("[512072, 1, 20, 24, 28676032]", s)

        day.stones.blink()
        s = day.stones.toString()
        println("$s")
        assertEquals("[512, 72, 2024, 2, 0, 2, 4, 2867, 6032]", s)

        day.stones.blink()
        s = day.stones.toString()
        println("$s")
        assertEquals("[1036288, 7, 2, 20, 24, 4048, 1, 4048, 8096, 28, 67, 60, 32]", s)

        day.stones.blink()
        s = day.stones.toString()
        println("$s")
        assertEquals("[2097446912, 14168, 4048, 2, 0, 2, 4, 40, 48, 2024, 40, 48, 80, 96, 2, 8, 6, 7, 6, 0, 3, 2]", s)

        day = Day11("src/main/res/input_test")
        day.solvePuzz1(6)
        var i = day.stones.stones.size
        assertEquals(22, i)

        day = Day11("src/main/res/input_test")
        day.solvePuzz1(25)
        i = day.stones.stones.size
        assertEquals(55312, i)

        day = Day11("src/main/res/input")
        day.solvePuzz1(25)
        i = day.stones.stones.size
        assertEquals(199986, i)
    }

}