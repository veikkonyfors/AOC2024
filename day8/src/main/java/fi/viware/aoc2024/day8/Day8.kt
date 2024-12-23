package fi.viware.aoc2024.day8

import java.io.File

class Day8(val inputFileName: String) {

    val equationLines: List<String>

    val antennaMap:Map

    init {
        // input file in src/main/resources/raw folder
        //val url: URL? = javaClass.classLoader.getResource(inputFileName).toURI().toURL()
        //val inputLines = url!!.openStream().bufferedReader().readLines()
        // input file in src/main/res folder
        val inputFile = File(inputFileName)
        equationLines = inputFile.readLines()
        antennaMap = Map(equationLines)
    }

    fun solvePuzz1(): Int{
        var totalAntinodeList = mutableListOf<Pair<Int, Int>>()
        antennaMap.frequencies.forEach {
            totalAntinodeList += antennaMap.calculateAntinodeLocationsForaFrequency(it)
        }
        var antinodeCount = totalAntinodeList.toSet().size
        return antinodeCount
    }


    fun solvePuzz2(): Int{
        return 0
    }
}