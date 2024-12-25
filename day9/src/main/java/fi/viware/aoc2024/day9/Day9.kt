package fi.viware.aoc2024.day9

import java.io.File

class Day9(inputFileName: String) {

    val fragmentLine: String

    val disk:Disk

    init {
        // input file in src/main/resources/raw folder
        //val url: URL? = javaClass.classLoader.getResource(inputFileName).toURI().toURL()
        //val inputLines = url!!.openStream().bufferedReader().readLines()
        // input file in src/main/res folder
        val inputFile = File(inputFileName)
        fragmentLine = inputFile.readLines()[0]
        disk = Disk(fragmentLine)
    }

    fun solvePuzz1(): Long{
        disk.deFrag()
        return disk.countCheckSum(disk.blocks)
    }


    fun solvePuzz2(): Long{
        val fileDefragmenter = FileDefragmenter(disk.blocks)
        fileDefragmenter.defrag()
        val l = disk.countCheckSum(fileDefragmenter.defragmentedBlocks )
        return l
    }

}