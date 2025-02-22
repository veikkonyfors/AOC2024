package fi.viware.aoc2024.day12

import java.io.File

class Day12(inputFileName: String) {

    val inputLines: List<String>

    val garden: Garden

    init {
        // input file in src/main/resources/raw folder
        //val url: URL? = javaClass.classLoader.getResource(inputFileName).toURI().toURL()
        //val inputLines = url!!.openStream().bufferedReader().readLines()
        // input file in src/main/res folder
        val inputFile = File(inputFileName)
        inputLines = inputFile.readLines()
        garden = Garden(inputLines)
    }

    fun solvePuzz1(): Int{
        return garden.totalCost()
    }


    fun solvePuzz2(): Int{
        return garden.totalDiscountedCost()
    }

}