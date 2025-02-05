package fi.viware.aoc2024.day12

class Garden(val inputLines: List<String>) {
    var gardenGrid: Array<CharArray>

    data class GroupInfo(val plant: Char, val size: Int, val perimeter: Int){
        val cost: Int

        init{ cost = size*perimeter}
    }
    init {
        val inputGrid = mutableListOf<CharArray>()
        inputLines.forEach { line ->
            inputGrid.add(line.toCharArray())
        }
        gardenGrid = inputGrid.toTypedArray()
    }

    fun countDistinctGroups(plant: Char): List<GroupInfo> {
        val visited = Array(gardenGrid.size) { BooleanArray(gardenGrid[0].size) }
        val directions = arrayOf(
            Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1)
        )
        val groups = mutableListOf<GroupInfo>()

        fun bfs(startRow: Int, startCol: Int, plant: Char): GroupInfo {
            val queue = ArrayDeque<Pair<Int, Int>>()
            queue.add(startRow to startCol)
            visited[startRow][startCol] = true
            var size = 0
            var perimeter = 0

            while (queue.isNotEmpty()) {
                val (r, c) = queue.removeFirst()
                size++

                for ((dr, dc) in directions) {
                    val nr = r + dr
                    val nc = c + dc
                    if (nr in gardenGrid.indices && nc in gardenGrid[0].indices) {
                        if (gardenGrid[nr][nc] == plant && !visited[nr][nc]) {
                            visited[nr][nc] = true
                            queue.add(nr to nc)
                        } else if (gardenGrid[nr][nc] != plant) {
                            perimeter++
                        }
                    } else {
                        perimeter++
                    }
                }
            }
            return GroupInfo(plant, size, perimeter)
        }

        for (row in gardenGrid.indices) {
            for (col in gardenGrid[0].indices) {
                if (gardenGrid[row][col] == plant && !visited[row][col]) {
                    groups.add(bfs(row, col, plant))
                }
            }
        }

        return groups
    }

    fun distinctPlants(): Set<Char>{
        return gardenGrid.flatMap { it.toList() }.toSet()
    }

    fun totalCost(): Int{
        val results = mutableListOf<Garden.GroupInfo>()
        distinctPlants().forEach {
            results.addAll(countDistinctGroups(it))
        }
        return results.sumOf { it.cost }
    }
}