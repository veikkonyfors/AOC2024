package fi.viware.aoc2024.day3

import java.io.File

class Day3(val inputFileName: String){

    val memoryLines: List<String>
    var fixedMemoryLines: List<String> = listOf()

    init {
        // input file in src/main/resources/raw folder
        //val url: URL? = javaClass.classLoader.getResource(inputFileName).toURI().toURL()
        //val inputLines = url!!.openStream().bufferedReader().readLines()
        // input file in src/main/res folder
        val inputFile = File(inputFileName)
        memoryLines = inputFile.readLines()
    }

    fun doPuzz1(): Int{

        val regex = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")
        var sum = 0
        memoryLines.forEach { line ->
            val fixedMemoryLine = regex.findAll(line)
            val r = fixedMemoryLine.map{
                val (first, second) = it.destructured
                first.toInt() * second.toInt()
            }.toList()
            val s = r.sum()
                sum += s
        }
        return sum
    }

    fun doPuzz2(): Int{
        val regex = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")
        val regex2 = Regex("""don't\(\).+?do\(\)""")
        val regex3 = Regex("""don't\(\).+?$""")
        var sum = 0
        var oneLine = memoryLines.joinToString("")


        oneLine = oneLine.replace(regex2, "")
        oneLine = oneLine.replace(regex3,"")
        val fixedMemoryLine = regex.findAll(oneLine)
        val r = fixedMemoryLine.map{
            val (first, second) = it.destructured
            first.toInt() * second.toInt()
        }.toList()
        val s = r.sum()
        return s
    }

    override fun toString(): String {
        return memoryLines.joinToString(separator = "\n"){ it }
    }
}