package fi.viware.aoc2024.day13

import java.io.File

class Day13(inputFileName: String) {

    val inputLines: List<String>

    val clawMachines: MutableList<ClawMachine> = mutableListOf()

    init {
        // input file in src/main/resources/raw folder
        //val url: URL? = javaClass.classLoader.getResource(inputFileName).toURI().toURL()
        //val inputLines = url!!.openStream().bufferedReader().readLines()
        // input file in src/main/res folder
        val inputFile = File(inputFileName)
        inputLines = inputFile.readLines()

        inputLines.chunked(4).forEach {
            val aValues = Regex("X\\+(\\d+), Y\\+(\\d+)").find(it[0])?.groupValues
            val bValues = Regex("X\\+(\\d+), Y\\+(\\d+)").find(it[1])?.groupValues
            val priceValues = Regex("X\\=(\\d+), Y\\=(\\d+)").find(it[2])?.groupValues

            clawMachines.add(
                ClawMachine(
                    aValues!![1].toInt() to aValues[2].toInt(),
                    bValues!![1].toInt() to bValues[2].toInt(),
                    priceValues!![1].toInt() to priceValues[2].toInt()
                )
            )
        }
    }

    fun solvePuzz1(): Int{
        var i = 0
        clawMachines.forEach {
            i += it.cost(it.cheapestPushes(it.bMax()))
        }
        return i
    }


    fun solvePuzz2(): Int{
        return inputLines.size
    }

}