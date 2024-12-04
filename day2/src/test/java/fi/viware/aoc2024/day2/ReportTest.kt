package fi.viware.aoc2024.day2

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class ReportTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun day2Puzz1(){

        var day2 = Day2("src/main/res/input_test")
        var s = day2.toString()
        println("$s")
        assertEquals("7 6 4 2 1\n1 2 7 8 9\n9 7 6 2 1\n1 3 2 4 5\n8 6 4 4 1\n1 3 6 7 9",s)

        var report = Report(day2.reportLines[0])
        s = report.toString()
        println("\n$s")
        assertEquals("7 6 4 2 1",s)

        var b = report.isIncreasing()
        println("\n$b")
        assertEquals(false,b)

        b = report.isDecreasing()
        println("\n$b")
        assertEquals(true,b)

        b = report.isTight()
        println("\n$b")
        assertEquals(true,b)

        b = report.isSafe()
        println("\n$b")
        assertEquals(true,b)

        report = Report(day2.reportLines[1])
        b = report.isIncreasing()
        println("\n$b")
        assertEquals(true,b)

        b = report.isDecreasing()
        println("\n$b")
        assertEquals(false,b)

        b = report.isTight()
        println("\n$b")
        assertEquals(false,b)

        b = report.isSafe()
        println("\n$b")
        assertEquals(false,b)

        report = day2.reportList[0]
        b = report.isSafe()
        println("\n$b")
        assertEquals(true,b)

        report = day2.reportList[1]
        b = report.isSafe()
        println("\n$b")
        assertEquals(false,b)

        var i = day2.safeCount()
        println("\n$i")
        assertEquals(2,i)

        day2 = Day2("src/main/res/input_test")
        i = day2.safeCount()
        println("\n$i")
        assertEquals(2,i)

        day2 = Day2("src/main/res/input")
        i = day2.safeCount()
        println("\n$i")
        assertEquals(359,i)
    }

    @Test
    fun day2Puzz2(){

        var day2 = Day2("src/main/res/input_test")
        var s = day2.toString()
        println("$s")
        assertEquals("7 6 4 2 1\n1 2 7 8 9\n9 7 6 2 1\n1 3 2 4 5\n8 6 4 4 1\n1 3 6 7 9",s)

        var report = Report(day2.reportLines[0])
        s = report.toString()
        println("\n$s")
        assertEquals("7 6 4 2 1",s)

        report = Report("1 2 7 8 9")
        var b = report.isIncreasingDampenedAndTight()
        println("\n$b")
        assertEquals(false,b)

        report = Report("1 3 2 4 5")
        b = report.isIncreasingDampenedAndTight()
        println("\n$b")
        println("${report.dampenedReport}")
        assertEquals(true,b)

        report = Report("1 3 2 4 9")
        b = report.isIncreasingDampenedAndTight()
        println("\n$b")
        println("${report.dampenedReport}")
        assertEquals(false,b)

        report = Report("9 8 7 6 7 5")
        b = report.isDecreasingDampenedAndTight()
        println("\n$b")
        println("${report.dampenedReport}")
        assertEquals(true,b)

        report = Report("9 8 7 6 7 2")
        b = report.isDecreasingDampenedAndTight()
        println("\n$b")
        println("${report.dampenedReport}")
        assertEquals(false,b)

        report = Report("9 8 7 6 2")
        b = report.isTightDampened()
        println("\n$b")
        println("${report.dampenedReport}")
        assertEquals(true,b)

        report = Report("9 8 7 6 5")
        b = report.isTightDampened()
        println("\n$b")
        println("${report.dampenedReport}")
        assertEquals(true,b)

        day2 = Day2("src/main/res/input_test")
        var i = day2.safeCountDampened()
        println("\n$i")
        assertEquals(4,i)

        day2 = Day2("src/main/res/input")
        i = day2.safeCountDampened()
        println("\n$i")
        assertEquals(414,i)

    }

    @Test
    fun pinPoint(){

        //52 50 47 46 42 44

        var report: Report
        var b: Boolean

        report = Report("52 50 47 46 42 44")
        b = report.isSafeDampened()
        println("\n$b")
        println("$report")
        println("${report.dampenedReport}")
        assertEquals(true,b)

        report = Report("68 70 72 73 74 73 74 71")
        b = report.isSafeDampened()
        println("\n$b")
        println("$report")
        println("${report.dampenedReport}")
        assertEquals(false,b)

        report = Report("36 35 39 42 43 46 47")
        b = report.isSafeDampened()
        println("\n$b")
        println("$report")
        println("${report.dampenedReport}")
        assertEquals(true,b)

        report = Report("25 23 25 28 29 32 35")
        b = report.isSafeDampened()
        println("\n$b")
        println("$report")
        println("${report.dampenedReport}")
        assertEquals(true,b)

        report = Report("18 20 22 25 28 31 35")
        b = report.isSafeDampened()
        println("\n$b")
        println("$report")
        println("${report.dampenedReport}")
        assertEquals(true,b)

    }

    /*
7 6 4 2 1: Safe without removing any level.
1 2 7 8 9: Unsafe regardless of which level is removed.
9 7 6 2 1: Unsafe regardless of which level is removed.
1 3 2 4 5: Safe by removing the second level, 3.
8 6 4 4 1: Safe by removing the third level, 4.
1 3 6 7 9: Safe without removing any level.
 */

    @Test
    fun puzzAlone(){
        var day2 = Day2("src/main/res/input_test")
        var i = day2.safeCountDampened()
        println("\n$i")
        assertEquals(4,i)
    }

    @Test
    fun loopInput(){

        var day2 = Day2("src/main/res/input")
        var bs: Boolean
        var countOk = 0
        var countDok = 0
        var countNok = 0
        var line = 0
        day2.reportList.forEach {
            line++
            bs = it.isSafe()
            if (bs) {
                countOk++
                println("$it")
            } else if (it.isSafeDampened()){
                countDok++
                println("$it")
            } else {
                countNok++
                //println("$line: $it: Unsafe, countNok: $countNok")
            }
        }
        println("lines: $line, countOk:$countOk, countDok:$countDok, countOk + countDok:${countOk + countDok}, countNok:$countNok")
    }
}

/* 395 399 410
414 after increasingandtight
471 after decreasingandtight
That's not the right answer;
your answer is too low. If you're stuck, make sure you're using the full input data;
there are also some general tips on the about page, or you can ask for hints on the subreddit.
Please wait one minute before trying again. [Return to Day 2]

471 didn't say was it low or high anymore on the fourth guess
888 after   if(d) return true // dampenedReport.isTight() change, with dampenedReport.isTight() gave the 471
 */