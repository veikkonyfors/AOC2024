package fi.viware.aoc2024.day11

class Stones(val inputLines: List<String>) {
    var stones: MutableList<Long> = mutableListOf()

    var stonesMap: MutableMap<Long, Long> = mutableMapOf()

    init {
        inputLines.forEach { line ->
            line.split(" ").forEach {
                stones.add(it.toLong())
                stonesMap[it.toLong()] = stonesMap.getOrPut(it.toLong()) { 0 } + 1
            }

        }
    }

    fun blinkMapped(){  // 25 blinks ok, 75 lagging
        val newStonesMap = mutableMapOf<Long, Long>()

        stonesMap.forEach {
            if (it.key == 0L) {newStonesMap[1L] = newStonesMap.getOrPut(1L) { 0L } + stonesMap[it.key]!!}
            else if ( it.key.toString().length%2 == 0) {
                val leftKey = it.key.toString().substring(0,it.key.toString().length/2).toLong()
                val rightKey = it.key.toString().substring(it.key.toString().length/2).toLong()
                val oldValue = stonesMap[it.key]
                newStonesMap[leftKey] = newStonesMap.getOrPut(leftKey) { 0 } + oldValue!!
                newStonesMap[rightKey] = newStonesMap.getOrPut(rightKey) { 0 } + oldValue!!
            } else {
                val newKey = it.key * 2024
                val oldValue = stonesMap[it.key]
                newStonesMap[newKey] = newStonesMap.getOrPut(newKey) { 0 } + oldValue!!
            }
        }
        stonesMap = newStonesMap
    }

    fun blink(){
        var index = 0
        var numAddedItems = 0

        while(true) {
            val s = stones[index + numAddedItems]
            if (s == 0L) stones[index + numAddedItems] = 1
            else if ( s.toString().length%2 == 0) {
                stones[index + numAddedItems] = s.toString().substring(0,s.toString().length/2).toLong()
                stones.add(index + numAddedItems + 1,s.toString().substring(s.toString().length/2).toLong())
                numAddedItems++
            }
            else stones[index + numAddedItems] = s * 2024
            index++
            if (index + numAddedItems >= stones.size) break
        }
    }

    override fun toString(): String {
        return stones.toString()
    }

}