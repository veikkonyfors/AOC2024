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

        /*
        day.stones.blink()
        s = day.stones.toString()
        println("$s")
        assertEquals("[2097446912, 14168, 4048, 2, 0, 2, 4, 40, 48, 2024, 40, 48, 80, 96, 2, 8, 6, 7, 6, 0, 3, 2]", s)

         */

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


        /*
        Simplest brute force solution takes too long
        day = Day11("src/main/res/input_test")
        day.solvePuzz1(75)
        i = day.stones.stones.size
        assertEquals(55312, i)
        */

    }

    @Test
    fun puzz2Tests() {
        var day = Day11("src/main/res/input_test")
        var s = day.stones.stonesMap.toString()
        println("$s")
        assertEquals("{125=1, 17=1}", s)

        day.stones.blinkMapped()
        s = day.stones.stonesMap.toString()
        println("$s")
        assertEquals("{253000=1, 1=1, 7=1}", s)

        day.stones.blinkMapped()
        s = day.stones.stonesMap.toString()
        println("$s")
        assertEquals("{253=1, 0=1, 2024=1, 14168=1}", s)

        day.stones.blinkMapped()
        s = day.stones.stonesMap.toString()
        println("$s")
        assertEquals("{512072=1, 1=1, 20=1, 24=1, 28676032=1}", s)

        repeat(4) { day.stones.blink()}
        s = day.stones.toString() + " ${day.stones.stones.size}"
        println("$s")

        day.stones.blinkMapped()
        s = day.stones.stonesMap.toString()
        println("$s  ${day.stones.stonesMap.values.sum()}")
        assertEquals("{512=1, 72=1, 2024=1, 2=2, 0=1, 4=1, 2867=1, 6032=1}", s)

        repeat(1) { day.stones.blink()}
        s = day.stones.toString() + " ${day.stones.stones.size}"
        println("$s")

        day.stones.blinkMapped()
        s = day.stones.stonesMap.toString()
        println("$s  ${day.stones.stonesMap.values.sum()}")
        assertEquals("{1036288=1, 7=1, 2=1, 20=1, 24=1, 4048=2, 1=1, 8096=1, 28=1, 67=1, 60=1, 32=1}", s)

        repeat(1) { day.stones.blink()}
        s = day.stones.toString() + " ${day.stones.stones.size}"
        println("$s")

        day.stones.blinkMapped()
        s = day.stones.stonesMap.toString()
        println("$s  ${day.stones.stonesMap.values.sum()}")
        assertEquals("{2097446912=1, 14168=1, 4048=1, 2=4, 0=2, 4=1, 40=2, 48=2, 2024=1, 80=1, 96=1, 8=1, 6=2, 7=1, 3=1}", s)


        day = Day11("src/main/res/input_test")
        day.solvePuzz2(6)
        var i = day.stones.stonesMap.values.sum()
        assertEquals(22, i)

        day = Day11("src/main/res/input_test")
        day.solvePuzz2(25)
        i = day.stones.stonesMap.values.sum()
        assertEquals(55312, i)

        day = Day11("src/main/res/input")
        day.solvePuzz2(25)
        i = day.stones.stonesMap.values.sum()
        assertEquals(199986, i)

        day = Day11("src/main/res/input")
        day.solvePuzz2(75)
        i = day.stones.stonesMap.values.sum()
        assertEquals(236804088748754, i)
    }

    /**
     * 4.2.2024 1066883794 too low
     */


}