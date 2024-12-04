package fi.viware.aoc2024.day2

import java.io.File

class Day2(val inputFileName: String){

    val reportLines: List<String>
    var reportList: MutableList<Report> = mutableListOf()

    init {
        // input file in src/main/resources/raw folder
        //val url: URL? = javaClass.classLoader.getResource(inputFileName).toURI().toURL()
        //val inputLines = url!!.openStream().bufferedReader().readLines()
        // input file in src/main/res folder
        val inputFile = File(inputFileName)
        reportLines = inputFile.readLines()
        reportLines.forEach {
            reportList.add(Report(it))
        }
    }

    fun safeCount(): Int{
        var count = 0
        reportList.forEach {
            if (it.isSafe()) count++
        }

        return count
    }

    fun safeCountDampened(): Int{
        var count = 0
        reportList.forEach {
            if (it.isSafeDampened()) count++
        }

        return count
    }

    override fun toString(): String {
        return reportLines.joinToString(separator = "\n"){ it.uppercase() }
    }
}