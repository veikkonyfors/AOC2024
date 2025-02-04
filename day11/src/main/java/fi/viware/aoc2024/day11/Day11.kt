package fi.viware.aoc2024.day11

import java.io.File

class Day11(inputFileName: String) {

    val inputLines: List<String>

    val stones: Stones

    init {
        // input file in src/main/resources/raw folder
        //val url: URL? = javaClass.classLoader.getResource(inputFileName).toURI().toURL()
        //val inputLines = url!!.openStream().bufferedReader().readLines()
        // input file in src/main/res folder
        val inputFile = File(inputFileName)
        inputLines = inputFile.readLines()
        stones = Stones(inputLines)
    }

    fun solvePuzz1(blinks: Int): Int{
        repeat(blinks){
            stones.blink()
        }
        return stones.stones.size
    }


    fun solvePuzz2(blinks: Int): Long{
        repeat(blinks){
            stones.blinkMapped()
        }
        return stones.stonesMap.values.sum()
    }

}