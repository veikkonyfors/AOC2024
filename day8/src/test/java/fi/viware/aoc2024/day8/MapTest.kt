package fi.viware.aoc2024.day8

import org.junit.Assert.*
import org.junit.Test

class MapTest(){

    @Test
    fun puzz1Tests(){

        var day = Day8("src/main/res/input_test")
        var map = day.antennaMap
        var s = map.toString()
        //println("$s")
        assertEquals("............\n........0...\n.....0......\n.......0....\n....0.......\n......A.....\n............\n............\n........A...\n.........A..\n............\n............\n0 0 0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0 0 0",s)

        s = map.frequencies.joinToString{ it.toString() }
        //println("$s")
        assertEquals("0, A", s)

        var antennaLocations = map.getAntennaLocationsByFrequency(map.frequencies.first())
        s = antennaLocations.joinToString { "(" + it.first.toString() + ", " + it.second.toString() + ")"}
        //println("$s")
        assertEquals("(1, 8), (2, 5), (3, 7), (4, 4)",s)

        antennaLocations = map.findAntinodeLocationsForaFrequency(map.frequencies.first())
        s = antennaLocations.joinToString { "(" + it.first.toString() + ", " + it.second.toString() + ")"}
        //println("$s")
        assertEquals("(0, 11), (3, 2), (5, 6), (7, 0), (1, 3), (4, 9), (0, 6), (6, 3), (2, 10), (5, 1)",s)

        day = Day8("src/main/res/input_test")
        var totalAntinodeList = mutableListOf<Pair<Int, Int>>()
        day.antennaMap.frequencies.forEach {
            totalAntinodeList += day.antennaMap.findAntinodeLocationsForaFrequency(it)
        }
        s = totalAntinodeList.toSet().joinToString { "(" + it.first.toString() + ", " + it.second.toString() + ")"}
        //println("$s")
        assertEquals("(0, 11), (3, 2), (5, 6), (7, 0), (1, 3), (4, 9), (0, 6), (6, 3), (2, 10), (5, 1), (2, 4), (11, 10), (7, 7), (10, 10)",s)
        var i = totalAntinodeList.toSet().size
        //println("$i")
        assertEquals(14,i)

        i = day.solvePuzz1()
        println("$i")
        assertEquals(14,i)

        day = Day8("src/main/res/input")
        i = day.solvePuzz1()
        println("$i")
        assertEquals(396,i)
    }

    /*
    23.12.2024 09:30 406 too high
    23.12.2024 10:00 396 ok
     */

    @Test
    fun puzz2Tests(){

        var day = Day8("src/main/res/input_test2")
        var map = day.antennaMap
        var s = map.toString()
        println("$s")
        assertEquals("T....#....\n...T......\n.T....#...\n.........#\n..#.......\n..........\n...#......\n..........\n....#.....\n..........\n0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0 0 0",s)

        day = Day8("src/main/res/input_test")
        var totalAntinodeList = mutableListOf<Pair<Int, Int>>()
        day.antennaMap.frequencies.forEach {
            totalAntinodeList += day.antennaMap.findInlineAntinodeLocationsForaFrequency(it)
        }
        s = totalAntinodeList.toSet().joinToString { "(" + it.first.toString() + ", " + it.second.toString() + ")"}
        println("$s")
        //assertEquals("(0, 11), (3, 2), (5, 6), (7, 0), (1, 3), (4, 9), (0, 6), (6, 3), (2, 10), (5, 1), (2, 4), (11, 10), (7, 7), (10, 10)",s)
        var i = totalAntinodeList.toSet().size
        println("$i")
        assertEquals(34,i)

        day = Day8("src/main/res/input_test")
        i = day.solvePuzz2()
        //println("$i")
        assertEquals(34, i)

        day = Day8("src/main/res/input")
        i = day.solvePuzz2()
        //println("$i")
        assertEquals(1200, i)
    }
}

/*
23.12.2024 13:30 1200 ok
 */