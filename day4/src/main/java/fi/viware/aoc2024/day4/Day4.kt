package fi.viware.aoc2024.day4

import java.io.File

class Day4(val inputFileName: String) {
    val xmasGridLines: List<String>
    val xmasGrid: XmasGrid

    init {
        // input file in src/main/resources/raw folder
        //val url: URL? = javaClass.classLoader.getResource(inputFileName).toURI().toURL()
        //val inputLines = url!!.openStream().bufferedReader().readLines()
        // input file in src/main/res folder
        val inputFile = File(inputFileName)
        xmasGridLines = inputFile.readLines()
        xmasGrid = XmasGrid(xmasGridLines)
    }
}