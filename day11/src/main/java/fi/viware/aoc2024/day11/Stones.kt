package fi.viware.aoc2024.day11

import java.util.LinkedList
import java.util.Queue

class Stones(val inputLines: List<String>) {
    var stones: MutableList<Long> = mutableListOf()

    init {
        inputLines.forEach { line ->
            line.split(" ").forEach {
                stones.add(it.toLong())
            }

        }
    }

    fun blink(){
        val newStones = stones.toMutableList()
        var numAddedItems = 0

        stones.forEachIndexed { index, s ->
            if (s == 0L) newStones[index + numAddedItems] = 1
            else if ( s.toString().length%2 == 0) {
                newStones[index + numAddedItems] = s.toString().substring(0,s.toString().length/2).toLong()
                newStones.add(index + numAddedItems + 1,s.toString().substring(s.toString().length/2).toLong())
                numAddedItems++
            }
            else newStones[index + numAddedItems] = s * 2024
        }
        stones = newStones
    }

    override fun toString(): String {
        return stones.toString()
    }

}