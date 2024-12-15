package fi.viware.day7

import java.io.File

class Day7(val inputFileName: String) {

    val equationLines: List<String>

    init {
        // input file in src/main/resources/raw folder
        //val url: URL? = javaClass.classLoader.getResource(inputFileName).toURI().toURL()
        //val inputLines = url!!.openStream().bufferedReader().readLines()
        // input file in src/main/res folder
        val inputFile = File(inputFileName)
        equationLines = inputFile.readLines()
    }

    fun solvePuzz1(): Long{
        var sum = 0L
        equationLines.forEach {
            val eq = Equation(it)
            if (eq.verifyEquation()) sum += eq.result
        }
        return sum
    }


    fun solvePuzz2(): Int{
        return 0
    }
}