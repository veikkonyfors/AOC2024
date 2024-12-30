package fi.viware.aoc2024.day10

import java.util.LinkedList
import java.util.Queue

class TopoGraphy(val inputLines: List<String>) {

    val topology: Array<IntArray> = inputLines.map { it.map { it.toString().toInt()}.toIntArray()}.toTypedArray()

    val topoRows = topology.size
    val topoCols = topology[0].size

    val directions = arrayOf(
        Pair(0, 1),
        Pair(1, 0),
        Pair(0, -1),
        Pair(-1, 0)
    )

    fun findRoute(start: Pair<Int, Int>, end: Pair<Int, Int>): Int{

        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(start)

        val visited = Array(topoRows) { BooleanArray(topoCols) }
        visited[start.first][start.second] = true

        while (queue.isNotEmpty()) {
            val (currentRow, currentCol) = queue.poll()

            if (currentRow == end.first && currentCol == end.second) {
                return 1
            }

            for ((dr, dc) in directions) {
                val newRow = currentRow + dr
                val newCol = currentCol + dc

                if (newRow in 0 until topoRows && newCol in 0 until topoCols &&
                    !visited[newRow][newCol] &&
                    topology[newRow][newCol] - topology[currentRow][currentCol] == 1) {
                    visited[newRow][newCol] = true
                    queue.add(Pair(newRow, newCol))
                }
            }
        }

        return 0
    }


    fun findValue(value: Int): List<Pair<Int, Int>>{
        val startingPoints = mutableListOf<Pair<Int, Int>>()

        topology.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, i ->
                if (i == value) {
                    startingPoints.add(Pair(rowIndex, colIndex))
                }
            }
        }
        return startingPoints
    }

    fun findStarts(): List<Pair<Int, Int>>{
        return findValue(0)
    }
    fun findEnds(): List<Pair<Int, Int>>{
        return findValue(9)
    }

    fun countScores(): Int{
        var score = 0
        findStarts().forEach { s->
            findEnds().forEach oneEnd@{ e ->
                if (findRoute(s, e) == 0) return@oneEnd
                score += 1
            }
        }
        return  score
    }

}