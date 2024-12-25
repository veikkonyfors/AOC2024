package fi.viware.aoc2024.day9

class Disk(val fragmentLine: String) {

    var blocks: MutableList<Int> = mutableListOf()

    init {
        var id = 0
        var free = true
        var idOrFree = 0
        fragmentLine.forEachIndexed { index, c ->
            free = !free
            idOrFree = when(free) { true -> -1; else -> id++ }
            for (i in 0..<c.digitToInt()) blocks.add(idOrFree)
        }
    }

    fun countCheckSum(blocks: List<Int>): Long{
        var checkSum = 0L
        checkSum = blocks.mapIndexed { index, i -> if (i != -1) index * i else 0 }.sumOf { it.toLong() }
        return  checkSum
    }

    fun deFrag(){
        var firstFree = blocks.indexOf(-1)
        var lastBlock = blocks.withIndex().lastOrNull { it.value != -1 }?.index ?: -1
        while (firstFree < lastBlock){
            blocks[firstFree] = blocks[lastBlock]
            blocks[lastBlock] = -1
            firstFree = blocks.indexOf(-1)
            lastBlock = blocks.withIndex().lastOrNull { it.value != -1 }?.index ?: -1
        }
    }
}