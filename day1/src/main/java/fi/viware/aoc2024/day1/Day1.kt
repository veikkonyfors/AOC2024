package fi.viware.aoc2024.day1

import java.io.File

class Day1(val inputFileName: String){

    val inputLines: List<String>
    init {
        // input file in src/main/resources/raw folder
        //val url: URL? = javaClass.classLoader.getResource(inputFileName).toURI().toURL()
        //val inputLines = url!!.openStream().bufferedReader().readLines()
        // input file in src/main/res folder
        val inputFile = File(inputFileName)
        inputLines = inputFile.readLines()
    }

    override fun toString(): String {
        return inputLines.joinToString(separator = ", "){ it.uppercase() }
    }
}