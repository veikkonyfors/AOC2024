package fi.viware.aoc2024.day5

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class Day5Test {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    // testing with update.sortPages() method
    fun puzz2Tests(){

        var s: String = ""
        var i = 0
        var b = false

        var day5 = Day5("src/main/res/input_test")
        s = day5.updates.updates[3].sortPages(day5.rules ).toString()
        println("$s")
        assertEquals("[97, 75, 47, 61, 53]",s)

        i = day5.solvePuzz2()
        println("$i")
        assertEquals(123,i)

        day5 = Day5("src/main/res/input")
        i = day5.solvePuzz2()
        println("$i")
        assertEquals(5833,i)

    }
    @Test
    fun puzz1Tests(){
        var s: String = ""
        var i = 0
        var b = false

        var day5 = Day5("src/main/res/input_test")
        var updates = day5.updates

        val u = Update("75,97,47,61,53")
        val r = listOf("47|53", "97|13", "97|61", "97|47", "75|29", "61|13", "75|53", "29|13", "97|29", "53|29", "61|53", "97|53", "61|29", "47|13", "75|47", "97|75", "47|61", "75|61", "47|29", "75|13", "53|13")
        b = u.isCorrectlyOrdered(r)
        println("$b")
        assertEquals(false,b)

        b = u.isCorrectlyOrdered(listOf("97|75"))
        println("$b")
        assertEquals(false,b)

        s = day5.rules.toString()
        println("$s")
        assertEquals("[47|53, 97|13, 97|61, 97|47, 75|29, 61|13, 75|53, 29|13, 97|29, 53|29, 61|53, 97|53, 61|29, 47|13, 75|47, 97|75, 47|61, 75|61, 47|29, 75|13, 53|13]",s)

        s = day5.updates.toString()
        println("$s")
        assertEquals("75,47,61,53,29 | 97,61,53,29,13 | 75,29,13 | 75,97,47,61,53 | 61,13,29 | 97,13,75,29,47",s)

        i = updates.updates[5].getMiddleNumber()
        println("$i")
        assertEquals(75,i)

        i = day5.solvePuzz1()
        println("$i")
        assertEquals(143,i)

        day5 = Day5("src/main/res/input")
        i = day5.solvePuzz1()
        println("$i")
        assertEquals(5329,i)

    }

}