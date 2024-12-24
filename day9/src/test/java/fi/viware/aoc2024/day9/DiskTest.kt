package fi.viware.aoc2024.day9

import org.junit.Assert.*
import org.junit.Test

class DiskTest(){

    @Test
    fun puzz1Tests(){

        var day = Day9("src/main/res/input_test")
        var s = day.disk.blocks.toString()
        println("$s")
        assertEquals("[0, 0, -1, -1, -1, 1, 1, 1, -1, -1, -1, 2, -1, -1, -1, 3, 3, 3, -1, 4, 4, -1, 5, 5, 5, 5, -1, 6, 6, 6, 6, -1, 7, 7, 7, -1, 8, 8, 8, 8, 9, 9]", s)

        day.disk.deFrag()
        s = day.disk.blocks.toString()
        println("$s")
        assertEquals("[0, 0, 9, 9, 8, 1, 1, 1, 8, 8, 8, 2, 7, 7, 7, 3, 3, 3, 6, 4, 4, 6, 5, 5, 5, 5, 6, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]", s)

        var l = day.disk.countCheckSum()
        println("$l")
        assertEquals(1928,l)

        day = Day9("src/main/res/input")
        day.disk.deFrag()
        l = day.disk.countCheckSum()
        println("$l")
        assertEquals(0,l)
    }
}