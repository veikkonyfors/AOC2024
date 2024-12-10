package fi.viware.aoc2024.day5

class Updates(updateLines: List<String>) {
    val updates = mutableListOf<Update>()

    init {
        updateLines.forEach {
            updates.add(Update(it))
        }
    }


    override fun toString(): String {
        return updates.joinToString(separator = " | ") { it.toString() }
    }
}