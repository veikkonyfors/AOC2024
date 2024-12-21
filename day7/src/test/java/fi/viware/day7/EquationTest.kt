package fi.viware.day7

import org.junit.Assert.*
import org.junit.Test


class EquationTest(){

    @Test
    fun Puzz2Tests2(){
        var day = Day7("src/main/res/input_test")
        var eq = Equation(day.equationLines[4])
        var s = ""
        var b = false
        var sum = 0L

        b = eq.verifyEquation()
        println("$b")
        assertEquals(true, b)

        sum = day.solvePuzz1()
        println("$sum")
        assertEquals(11387, sum)

        eq = Equation("507905413443: 21 96 651 9 9 801 43")
        b = eq.verifyEquation()
        println("$b")
        assertEquals(true, b)


        day = Day7("src/main/res/input")
        sum = day.solvePuzz2()
        println("$sum")
        assertEquals(227921760109726, sum)

    }

    /*
    28760150883702 too low
    227921760109726 ok
     */

        @Test
    fun Puzz1Tests(){

        var day  = Day7("src/main/res/input_test")
        var eq = Equation(day.equationLines[0])
        var s = ""
        var b = false
        var sum = 0L

        s = eq.generatePermutations(5, listOf("+", "*")).joinToString(separator = "\n"){ it }
        //println("$s")
        assertEquals("+++++\n++++*\n+++*+\n+++**\n++*++\n++*+*\n++**+\n++***\n+*+++\n+*++*\n+*+*+\n+*+**\n+**++\n+**+*\n+***+\n+****\n*++++\n*+++*\n*++*+\n*++**\n*+*++\n*+*+*\n*+**+\n*+***\n**+++\n**++*\n**+*+\n**+**\n***++\n***+*\n****+\n*****",s)

        day = Day7("src/main/res/input_test")
        eq = Equation(day.equationLines[0])
        s = eq.toString()
        println("$s")
        assertEquals("190: 10 19; + *",s)

        eq = Equation("100: 10 10 4")
        s = eq.toString()
        println("$s")
        b = eq.verifyEquation()
        println("$b")

        sum = 0
        day.equationLines.forEach {
            eq = Equation(it)
            if (eq.verifyEquation()) sum += eq.result
        }
        println("$sum")

        day  = Day7("src/main/res/input")
        sum = 0
        day.equationLines.forEach {
            eq = Equation(it)
            if (eq.verifyEquation()) sum += eq.result
        }
        println("$sum")


    }
}

/*
4555081950037 too high
4555081946288
 */