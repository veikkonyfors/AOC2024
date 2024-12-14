package fi.viware.aoc2024.day6

import java.io.File

class Day6(val inputFileName: String) {
    val inputLines: MutableList<String>
    val area: Area
    init {
        // input file in src/main/resources/raw folder
        //val url: URL? = javaClass.classLoader.getResource(inputFileName).toURI().toURL()
        //val inputLines = url!!.openStream().bufferedReader().readLines()
        // input file in src/main/res folder
        val inputFile = File(inputFileName)
        inputLines = inputFile.readLines().toMutableList()
        area = Area(inputLines)
    }

    fun solvePuzz1(): Int{
        area.walk()
        return area.steps
    }


    fun solvePuzz2(): Int{
        return area.countLoopingExtraObstacles()
    }
}