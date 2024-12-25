package fi.viware.aoc2024.day9

class FileDefragmenter(val blocks: List<Int> ) {

    var defragmentedBlocks = blocks.toMutableList()
    var fileStart = blocks.size
    var fileLenght = 1

    fun findFileToBeMoved(): Boolean{
        val blocksLeftToScan = blocks.subList(0, fileStart)
        val lastFileEndIndex = blocksLeftToScan.indexOfLast { it != -1 }

        if (lastFileEndIndex == -1) return false

        fileStart = lastFileEndIndex
        while (blocksLeftToScan[lastFileEndIndex] == blocksLeftToScan[fileStart] && fileStart > 0) fileStart--
        fileStart += 1
        fileLenght = lastFileEndIndex - fileStart + 1

        //println("${blocksLeftToScan[lastFileEndIndex]}, $fileStart, $fileLenght, ${blocksLeftToScan.subList(fileStart, fileStart + fileLenght)}")
        if (fileLenght == 0) return false
        return true
    }

    fun findFreeBlock(size: Int): Int{
        var firstFree = -1
        var reducedBlock = defragmentedBlocks.toList()
        var blocksFirstFree = 0
        while (true) {
            firstFree = reducedBlock.indexOf(-1)
            if (firstFree == -1) return -1
            if (firstFree + blocksFirstFree > fileStart - fileLenght) return -1
            reducedBlock = reducedBlock.drop(firstFree)
            blocksFirstFree += firstFree
            val count = reducedBlock.takeWhile { it == -1 }.count()
            if (count >= fileLenght) return blocksFirstFree
            reducedBlock = reducedBlock.drop(count)
            blocksFirstFree += count
        }

        return -1
    }

    fun moveFile(freeStart: Int){
        var i = freeStart
        var j = fileStart
        repeat (fileLenght) { defragmentedBlocks[i++] = blocks[fileStart]; defragmentedBlocks[j++] = -1}
    }

    fun defrag(){
        while (findFileToBeMoved()){
            var i = findFreeBlock(fileLenght)
            if (i != -1) moveFile(i)
        }
    }
}