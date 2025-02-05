package fi.viware.aoc2024.day12

import org.junit.Assert.*
import org.junit.Test

class GardenTest(){

    @Test
    fun puzz1Test() {

        var day = Day12("src/main/res/input_test")
        var s = day.garden.gardenGrid.joinToString("\n") { it.joinToString("") }
        println("$s")
        assertEquals("RRRRIICCFF\nRRRRIICCCF\nVVRRRCCFFF\nVVRCCCJFFF\nVVVVCJJCFE\nVVIVCCJJEE\nVVIIICJJEE\nMIIIIIJJEE\nMIIISIJEEE\nMMMISSJEEE",s)

        var result = day.garden.countDistinctGroups('I')
        s = "${result.size} ${result.joinToString(separator = ", ") {
            "${it.plant}:${it.size}:${it.perimeter}:${it.cost}"
        }}"
        println("$s")
        assertEquals("2 I:4:8:32, I:14:22:308", s)

        result = day.garden.countDistinctGroups('I')
        s = "${result.size} ${result.joinToString(separator = ", ") { 
            "${it.plant}:${it.size}:${it.perimeter}:${it.cost}"
        }}"
        println("$s")
        assertEquals("2 I:4:8:32, I:14:22:308", s)

        s = day.garden.distinctPlants().toString()
        println("$s")
        assertEquals("[R, I, C, F, V, J, E, M, S]", s)

        result = day.garden.countDistinctGroups('R')
        s = "${result.size} ${result.joinToString(separator = ", ") {
            "${it.plant}:${it.size}:${it.perimeter}:${it.cost}"
        }}"
        println("$s")
        assertEquals("1 R:12:18:216", s)

        var results = mutableListOf<Garden.GroupInfo>()
        day.garden.distinctPlants().forEach {
            results.addAll(day.garden.countDistinctGroups(it))
        }
        var i = results.sumOf {
            it.cost
        }
        println("$i")
        assertEquals(1930, i)

        day = Day12("src/main/res/input")
        results = mutableListOf<Garden.GroupInfo>()
        day.garden.distinctPlants().forEach {
            results.addAll(day.garden.countDistinctGroups(it))
        }
        i = results.sumOf {
            it.cost
        }
        println("$i")
        assertEquals(1370258, i)


    }
}