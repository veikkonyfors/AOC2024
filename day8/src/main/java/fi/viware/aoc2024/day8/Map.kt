package fi.viware.aoc2024.day8

class Map( val mapLines:List<String>) {
    val antennaMap: Array<CharArray> = mapLines.map { it.toCharArray() }.toTypedArray()
    val antinodeMap: Array<IntArray> = Array(antennaMap.size) { IntArray(antennaMap[0].size ) {0}}
    val frequencies = antennaMap.map { it.concatToString() }.joinToString(separator = "") { it }.filter { it != '.' }.toSet()
    val a = antennaMap.map { it.concatToString() }
    val b = a.joinToString { it }

    fun findInlineAntinodeLocationsForaFrequency(frequency: Char): List<Pair<Int, Int>> {
        val antennaLocationList = getAntennaLocationsByFrequency(frequency)
        var inlineAntinodeList = mutableListOf<Pair<Int, Int>>()

        antennaLocationList.forEachIndexed { index, pair ->
            inlineAntinodeList.add(pair)
            antennaLocationList.forEachIndexed inner@{ index2, pair2 ->
                if (index2 <= index) return@inner
                var rightDownOut = false
                var leftUpOut = false
                var round = 1
                while (!(rightDownOut && leftUpOut)) {
                    val dy = round*(pair.first - pair2.first)
                    val dx = round*(pair.second - pair2.second)
                    if (pair.first + dy in 0..<antennaMap.size &&
                        pair.second + dx in 0..<antennaMap[0].size
                    ) inlineAntinodeList.add(pair.first + dy to pair.second + dx)
                    else rightDownOut = true
                    if (pair2.first - dy in antennaMap.indices &&
                        pair2.second - dx in 0..<antennaMap[0].size
                    ) inlineAntinodeList.add(pair2.first - dy to pair2.second - dx)
                    else leftUpOut = true

                    round += 1
                }
            }

        }

        return  inlineAntinodeList
    }

    fun findAntinodeLocationsForaFrequency(frequency: Char): List<Pair<Int, Int>>{
        val antennaLocationList = getAntennaLocationsByFrequency(frequency)
        var antinodeList = mutableListOf<Pair<Int, Int>>()
        antennaLocationList.forEachIndexed { index, pair ->
            antennaLocationList.forEachIndexed inner@{ index2, pair2 ->
                if (index2 <= index) return@inner
                val dy = pair.first - pair2.first
                val dx = pair.second - pair2.second
                if (pair.first + dy in 0..<antennaMap.size &&
                    pair.second + dx in 0..<antennaMap[0].size
                ) antinodeList.add(pair.first + dy to pair.second + dx)
                if (pair2.first - dy in antennaMap.indices &&
                    pair2.second - dx in 0..<antennaMap[0].size
                ) antinodeList.add(pair2.first - dy to pair2.second - dx)
            }

        }
        return antinodeList
    }
    fun getAntennaLocationsByFrequency(frequency: Char): List<Pair<Int, Int>>{
        var locationList = antennaMap.flatMapIndexed { rowIndex, row ->
            row.mapIndexed { colIndex, char ->
                if (char == frequency) Pair(rowIndex, colIndex) else null
            }.filterNotNull()
        }
        return locationList
    }

    override fun toString(): String {
        var s = antennaMap.map { it.concatToString() }.joinToString(separator = "\n") { it } + "\n"
        s += antinodeMap.map { it.joinToString(" ") }.joinToString(separator = "\n") { it }
        return s
    }
}



