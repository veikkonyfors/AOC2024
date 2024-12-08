package fi.viware.aoc2024.day4

class Row(val rowString: String) {

    fun countXmas(): Int{
        var count=0
        count = rowString.windowed("XMAS".length) { if (it == "XMAS") 1 else 0 }.sum()
        count += rowString.reversed().windowed("XMAS".length) { if (it == "XMAS") 1 else 0 }.sum()
        return count
    }

    override fun toString(): String {
        return rowString
    }
}