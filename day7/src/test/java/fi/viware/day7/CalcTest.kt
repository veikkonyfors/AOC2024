package fi.viware.day7

import org.junit.Assert.*
import org.junit.Test


class CalcTest(){

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