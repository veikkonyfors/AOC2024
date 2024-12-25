package fi.viware.aoc2024.day9

import org.junit.Assert.*
import org.junit.Test


class FileDefragmenterTest(){
    @Test
    fun puzz2Tests(){
        var day = Day9("src/main/res/input_test")
        var fileDefragmenter = FileDefragmenter(day.disk.blocks)
        var s = fileDefragmenter.defragmentedBlocks.toString()
        println("$s")
        assertEquals("[0, 0, -1, -1, -1, 1, 1, 1, -1, -1, -1, 2, -1, -1, -1, 3, 3, 3, -1, 4, 4, -1, 5, 5, 5, 5, -1, 6, 6, 6, 6, -1, 7, 7, 7, -1, 8, 8, 8, 8, 9, 9]", s)
        // 00...111...2...333.44.5555.6666.777.888899


        var fsl = fileDefragmenter.findFileToBeMoved()
        s = fileDefragmenter.defragmentedBlocks.subList(fileDefragmenter.fileStart, fileDefragmenter.fileStart + fileDefragmenter.fileLenght).toString()
        println("$s")
        assertEquals("[9, 9]", s)

        var i = fileDefragmenter.findFreeBlock(2)
        println("$i")
        assertEquals(2, i)

        fileDefragmenter.moveFile(i)
        s = fileDefragmenter.defragmentedBlocks.toString()
        println("$s")
        assertEquals("[0, 0, 9, 9, -1, 1, 1, 1, -1, -1, -1, 2, -1, -1, -1, 3, 3, 3, -1, 4, 4, -1, 5, 5, 5, 5, -1, 6, 6, 6, 6, -1, 7, 7, 7, -1, 8, 8, 8, 8, -1, -1]", s)
        // 0099.111...2...333.44.5555.6666.777.8888..


        fsl = fileDefragmenter.findFileToBeMoved()
        s = fileDefragmenter.defragmentedBlocks.subList(fileDefragmenter.fileStart, fileDefragmenter.fileStart + fileDefragmenter.fileLenght).toString()
        println("$s")
        assertEquals("[8, 8, 8, 8]", s)

        fsl = fileDefragmenter.findFileToBeMoved()
        s = fileDefragmenter.defragmentedBlocks.subList(fileDefragmenter.fileStart, fileDefragmenter.fileStart + fileDefragmenter.fileLenght).toString()
        println("$s")
        assertEquals("[7, 7, 7]", s)

        i = fileDefragmenter.findFreeBlock(3)
        println("$i")
        assertEquals(8, i)

        fileDefragmenter.moveFile(i)
        s = fileDefragmenter.defragmentedBlocks.toString()
        println("$s")
        assertEquals("[0, 0, 9, 9, -1, 1, 1, 1, 7, 7, 7, 2, -1, -1, -1, 3, 3, 3, -1, 4, 4, -1, 5, 5, 5, 5, -1, 6, 6, 6, 6, -1, -1, -1, -1, -1, 8, 8, 8, 8, -1, -1]", s)
        // 0099.1117772...333.44.5555.6666.....8888..

        fsl = fileDefragmenter.findFileToBeMoved()
        s = fileDefragmenter.defragmentedBlocks.subList(fileDefragmenter.fileStart, fileDefragmenter.fileStart + fileDefragmenter.fileLenght).toString()
        println("$s")
        assertEquals("[6, 6, 6, 6]", s)


        i = fileDefragmenter.findFreeBlock(4)
        println("$i")
        assertEquals(-1, i)

        fsl = fileDefragmenter.findFileToBeMoved()
        s = fileDefragmenter.defragmentedBlocks.subList(fileDefragmenter.fileStart, fileDefragmenter.fileStart + fileDefragmenter.fileLenght).toString()
        println("$s")
        assertEquals("[5, 5, 5, 5]", s)

        i = fileDefragmenter.findFreeBlock(4)
        println("$i")
        assertEquals(-1, i)

        fsl = fileDefragmenter.findFileToBeMoved()
        s = fileDefragmenter.defragmentedBlocks.subList(fileDefragmenter.fileStart, fileDefragmenter.fileStart + fileDefragmenter.fileLenght).toString()
        println("$s")
        assertEquals("[4, 4]", s)

        i = fileDefragmenter.findFreeBlock(2)
        println("$i")
        assertEquals(12, i)

        fileDefragmenter.moveFile(i)
        s = fileDefragmenter.defragmentedBlocks.toString()
        println("$s")
        assertEquals("[0, 0, 9, 9, -1, 1, 1, 1, 7, 7, 7, 2, 4, 4, -1, 3, 3, 3, -1, -1, -1, -1, 5, 5, 5, 5, -1, 6, 6, 6, 6, -1, -1, -1, -1, -1, 8, 8, 8, 8, -1, -1]", s)
        //0099.111777244.333....5555.6666.....8888..


        fsl = fileDefragmenter.findFileToBeMoved()
        s = fileDefragmenter.defragmentedBlocks.subList(fileDefragmenter.fileStart, fileDefragmenter.fileStart + fileDefragmenter.fileLenght).toString()
        println("$s")
        assertEquals("[3, 3, 3]", s)

        i = fileDefragmenter.findFreeBlock(3)
        println("$i")
        assertEquals(-1, i)

        fsl = fileDefragmenter.findFileToBeMoved()
        s = fileDefragmenter.defragmentedBlocks.subList(fileDefragmenter.fileStart, fileDefragmenter.fileStart + fileDefragmenter.fileLenght).toString()
        println("$s")
        assertEquals("[2]", s)

        i = fileDefragmenter.findFreeBlock(2)
        println("$i")
        assertEquals(4, i)

        fileDefragmenter.moveFile(i)
        s = fileDefragmenter.defragmentedBlocks.toString()
        println("$s")
        assertEquals("[0, 0, 9, 9, 2, 1, 1, 1, 7, 7, 7, -1, 4, 4, -1, 3, 3, 3, -1, -1, -1, -1, 5, 5, 5, 5, -1, 6, 6, 6, 6, -1, -1, -1, -1, -1, 8, 8, 8, 8, -1, -1]", s)
        // 00992111777.44.333....5555.6666.....8888..

        day = Day9("src/main/res/input_test")
        fileDefragmenter = FileDefragmenter(day.disk.blocks)
        fileDefragmenter.defrag()
        s = fileDefragmenter.defragmentedBlocks.toString()
        println("$s")
        assertEquals("[0, 0, 9, 9, 2, 1, 1, 1, 7, 7, 7, -1, 4, 4, -1, 3, 3, 3, -1, -1, -1, -1, 5, 5, 5, 5, -1, 6, 6, 6, 6, -1, -1, -1, -1, -1, 8, 8, 8, 8, -1, -1]", s)
        var l = day.disk.countCheckSum(fileDefragmenter.defragmentedBlocks )
        println("$l")
        assertEquals(2858, l)


        day = Day9("src/main/res/input")
        fileDefragmenter = FileDefragmenter(day.disk.blocks)
        fileDefragmenter.defrag()
        l = day.disk.countCheckSum(fileDefragmenter.defragmentedBlocks )
        println("$l")
        assertEquals(6237075041489, l)

    }

    /*
    25.12.2024: 12:30 6237075041489 OK
     */

}