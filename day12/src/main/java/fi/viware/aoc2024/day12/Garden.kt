package fi.viware.aoc2024.day12

class Garden(val inputLines: List<String>) {
    var gardenGrid: Array<CharArray>

    data class GroupInfo(val plant: Char, val size: Int, val perimeter: Int, val sides: Int = 0){
        val cost: Int
        val discountedPrice: Int
        init{
            cost = size * perimeter
            discountedPrice = size * sides
        }
    }
    init {
        val inputGrid = mutableListOf<CharArray>()
        inputLines.forEach { line ->
            inputGrid.add(line.toCharArray())
        }
        gardenGrid = inputGrid.toTypedArray()
    }

    fun nwCorner(r: Int, c: Int, plant: Char): Boolean{
        if (gardenGrid[r][c] != plant) return false
        if ((r == 0 || gardenGrid[r - 1][c] != gardenGrid[r][c]) &&  (c == 0 || gardenGrid[r][c - 1] != gardenGrid[r][c])) return true
        return false
    }

    fun neCorner(r: Int, c: Int, plant: Char): Boolean{
        if (gardenGrid[r][c] != plant) return false
        if ((r == 0 || gardenGrid[r - 1][c] != gardenGrid[r][c]) &&  (c >= gardenGrid[0].size - 1 || gardenGrid[r][c + 1] != gardenGrid[r][c])) return true
        return false
    }

    fun seCorner(r: Int, c: Int, plant: Char): Boolean{
        if (gardenGrid[r][c] != plant) return false
        if ((r >= gardenGrid.size -1 || gardenGrid[r + 1][c] != gardenGrid[r][c]) &&  (c >= gardenGrid[0].size - 1 || gardenGrid[r][c + 1] != gardenGrid[r][c])) return true
        return false
    }

    fun swCorner(r: Int, c: Int, plant: Char): Boolean{
        if (gardenGrid[r][c] != plant) return false
        if ((r >= gardenGrid.size - 1 || gardenGrid[r + 1][c] != gardenGrid[r][c]) &&  (c == 0 || gardenGrid[r][c - 1] != gardenGrid[r][c])) return true
        return false
    }

    fun nwInteriorCorner(r: Int, c: Int, plant: Char): Boolean{
        if (gardenGrid[r][c] != plant) return false
        if (r >= gardenGrid.size -1 || c >= gardenGrid[0].size - 1) return false
        if (gardenGrid[r + 1][c] == gardenGrid[r][c]
            && gardenGrid[r][c + 1] == gardenGrid[r][c]
            && gardenGrid[r + 1][c + 1] != gardenGrid[r][c]
        ) return true
        return false
    }

    fun neInteriorCorner(r: Int, c: Int, plant: Char): Boolean{
        if (gardenGrid[r][c] != plant) return false
        if (r >= gardenGrid.size -1 || c == 0) return false
        if (gardenGrid[r + 1][c] == gardenGrid[r][c]
            && gardenGrid[r][c - 1] == gardenGrid[r][c]
            && gardenGrid[r + 1][c - 1] != gardenGrid[r][c]
        ) return true
        return false
    }

    fun seInteriorCorner(r: Int, c: Int, plant: Char): Boolean{
        if (gardenGrid[r][c] != plant) return false
        if (r == 0 || c == 0) return false
        if (gardenGrid[r - 1][c] == gardenGrid[r][c]
            && gardenGrid[r][c - 1] == gardenGrid[r][c]
            && gardenGrid[r - 1][c - 1] != gardenGrid[r][c]
        ) return true
        return false
    }

    fun swInteriorCorner(r: Int, c: Int, plant: Char): Boolean{   // RRRII
        if (gardenGrid[r][c] != plant) return false               // RRRII
        if (r == 0 || c >= gardenGrid[0].size - 1) return false                        // RRRRR
        if (gardenGrid[r - 1][c] == gardenGrid[r][c]
            && gardenGrid[r][c + 1] == gardenGrid[r][c]
            && gardenGrid[r - 1][c + 1] != gardenGrid[r][c]
        ) return true
        return false
    }

    fun isCorner(r: Int, c: Int, plant: Char): Int {
        val bnw = nwCorner(r, c, plant)
        val bne = neCorner(r, c, plant)
        val bse = seCorner(r, c, plant)
        val bsw = swCorner(r, c, plant)
        val bnwi = nwInteriorCorner(r, c, plant)
        val bnei = neInteriorCorner(r, c, plant)
        val bsei = seInteriorCorner(r, c, plant)
        val bswi = swInteriorCorner(r, c, plant)
        var i = 0
        if (bnw) i++
        if (bne) i++
        if (bse) i++
        if (bsw) i++
        if (bnwi) i++
        if (bnei) i++
        if (bsei) i++
        if (bswi) i++
        val b = (nwCorner(r, c, plant)
                || neCorner(r, c, plant)
                || seCorner(r, c, plant)
                || swCorner(r, c, plant)
                || nwInteriorCorner(r, c, plant)
                || neInteriorCorner(r, c, plant)
                || seInteriorCorner(r, c, plant)
                || swInteriorCorner(r, c, plant)
                )
        return i
    }

    fun countDistinctGroups(plant: Char): List<GroupInfo> {
        val visited = Array(gardenGrid.size) { BooleanArray(gardenGrid[0].size ) { false } }
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
            var sides = 0

            while (queue.isNotEmpty()) {
                val (r, c) = queue.removeFirst()
                sides += isCorner(r, c, plant)
                size++

                for ((dr, dc) in directions) {
                    val nr = r + dr
                    val nc = c + dc
                    if (nr in gardenGrid.indices && nc in gardenGrid[0].indices) {
                        if (gardenGrid[nr][nc] == plant && !visited[nr][nc]) {
                            visited[nr][nc] = true
                            queue.add(nr to nc);
                        } else if (gardenGrid[nr][nc] != plant) {
                            perimeter++
                        }
                    } else {
                        perimeter++
                    }
                }
            }
            return GroupInfo(plant, size, perimeter, sides )
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

    fun totalDiscountedCost(): Int{
        val results = mutableListOf<Garden.GroupInfo>()
        distinctPlants().forEach {
            results.addAll(countDistinctGroups(it))
        }
        return results.sumOf { it.discountedPrice }
    }
}