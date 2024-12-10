package fi.viware.aoc2024.day5

import java.io.File

class Day5(val inputFileName: String) {
    val inputLines: List<String>
    val rules: List<String>
    val updates: Updates

    init {
        // input file in src/main/resources/raw folder
        //val url: URL? = javaClass.classLoader.getResource(inputFileName).toURI().toURL()
        //val inputLines = url!!.openStream().bufferedReader().readLines()
        // input file in src/main/res folder
        val inputFile = File(inputFileName)
        inputLines = inputFile.readLines()
        rules = inputLines.subList(0,inputLines.indexOf(""))
        updates = Updates(inputLines.subList(inputLines.indexOf("") + 1, inputLines.size))
    }

    fun solvePuzz1(): Int{
        var sum = 0
        updates.updates.forEach { u ->
            if (u.isCorrectlyOrdered(rules))
                    sum += u.getMiddleNumber()
        }
        return sum
    }


    fun solvePuzz2(): Int{
        var sum = 0
        var fixedUpdates = mutableListOf<Update>()
        updates.updates.forEach { u ->
            if (!u.isCorrectlyOrdered(rules)) {
                val fixedUpdate = u.sortPages(rules)
                fixedUpdates.add(fixedUpdate)
            }
        }

        fixedUpdates.forEach { u->
            sum += u.getMiddleNumber()
        }

        return sum
    }
}