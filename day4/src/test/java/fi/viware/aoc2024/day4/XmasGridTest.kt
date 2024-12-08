package fi.viware.aoc2024.day4

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class XmasGridTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun puzz1Test(){

        var r: Row
        var s: String
        var i: Int

        var day4 = Day4("src/main/res/input_test")
        var xmasGrid = XmasGrid(day4.xmasGridLines)

        i = xmasGrid.countXmas()
        println("$i\n")
        assertEquals(18,i)


        r = xmasGrid.getRow(4)
        println("\n$r")
        assertEquals("XMASAMXAMM",r.toString())
        i = r.countXmas()
        println("$i\n")
        assertEquals(2,i)

        r = xmasGrid.getColumn(6)
        println("$r")
        assertEquals("MSAMXXSSMM",r.toString())
        i = r.countXmas()
        println("$i\n")
        assertEquals(1,i)

        r = xmasGrid.getColumn(9)
        println("$r")
        assertEquals("MAMXMASAMX",r.toString())
        i = r.countXmas()
        println("$i\n")
        assertEquals(2,i)

        r = xmasGrid.getOneDiagonalSE(0, 0)
        println("$r")
        assertEquals("MSXMAXSAMX",r.toString())
        i = r.countXmas()
        println("$i\n")
        assertEquals(1,i)

        r = xmasGrid.getOneDiagonalSE(0, 4)
        println("$r")
        assertEquals("XMASMA",r.toString())
        i = r.countXmas()
        println("$i\n")
        assertEquals(1,i)

        r = xmasGrid.getOneDiagonalSE(4, 0)
        println("$r")
        assertEquals("XXSAMX",r.toString())
        i = r.countXmas()
        println("$i\n")
        assertEquals(1,i)

        r = xmasGrid.getOneDiagonalSW(3, 9)
        println("$r")
        assertEquals("XMASAMX",r.toString())
        i = r.countXmas()
        println("$i\n")
        assertEquals(2,i)

        r = xmasGrid.getOneDiagonalSW(0, 5)
        println("$r")
        assertEquals("XXSAMX",r.toString())
        i = r.countXmas()
        println("$i\n")
        assertEquals(1,i)

        s = xmasGrid.toString()
        println("$s\n")
        assertEquals("MMMSXXMASM\nMSAMXMSMSA\nAMXSXMAAMM\nMSAMASMSMX\nXMASAMXAMM\nXXAMMXXAMA\nSMSMSASXSS\nSAXAMASAAA\nMAMMMXMMMM\nMXMXAXMASX", s)

        s = xmasGrid.transposeToString()
        println("$s\n")
        assertEquals("MMAMXXSSMM\nMSMSMXMAAX\nMAXAAASXMM\nSMSMSMMAMX\nXXXAAMSMMA\nXMMSMXAAXX\nMSAMXXSSMM\nAMASAAXAMA\nSSMMMMSAMS\nMAMXMASAMX", s)

        s = xmasGrid.diagonalToString()
        println("$s\n")
        assertEquals("MSXMAXSAMX\n" +
                "MMASMASMS\nASAMSAMA\nMMAMMXM\nXXSAMX\nXMXMA\nSAMX\nSAM\nMX\nM\n" +
                "MASAMXXAM\nMMXSXASA\nSXMMAMS\nXMASMA\nXSAMM\nMMMX\nASM\nSA\nM\n" +
                "MSAMMMMXAM\nAMSXXSAMX\nMMAXAMMM\nXMASAMX\nMMXSXA\nASAMX\nSAMM\nAMA\nMS\nX\n" +
                "SMASAMSAM\nASMASAMS\nMMXMAXS\nXXSAMX\nXMXSX\nSAMM\nMSA\nMM\nM", s)

        day4 = Day4("src/main/res/input")
        xmasGrid = XmasGrid(day4.xmasGridLines)
        i = xmasGrid.countXmas()
        println("$i\n")
        assertEquals(2599,i)
    }
}

// 2194 Low