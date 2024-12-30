package fi.viware.aoc2024.day10

import java.io.File

class Day10(inputFileName: String) {

    val inputLines: List<String>

    val topoMap: TopoGraphy

    init {
        // input file in src/main/resources/raw folder
        //val url: URL? = javaClass.classLoader.getResource(inputFileName).toURI().toURL()
        //val inputLines = url!!.openStream().bufferedReader().readLines()
        // input file in src/main/res folder
        val inputFile = File(inputFileName)
        inputLines = inputFile.readLines()
        topoMap = TopoGraphy(inputLines)
    }

    fun solvePuzz1(): Int{
        return topoMap.countScores()
    }


    fun solvePuzz2(): Long{

        return 0
    }

}