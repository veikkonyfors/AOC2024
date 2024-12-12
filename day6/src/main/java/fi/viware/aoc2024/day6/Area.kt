package fi.viware.aoc2024.day6

class Area(var inputLines: MutableList<String>) {
    var area: Array<CharArray> = inputLines.map { it.toCharArray() }.toTypedArray()
    var startRow = -1
    var startColumn = -1
    var currentRow: Int
    var currentColumn: Int
    var direction = "^"
    var out = false
    var steps = 0
    val rows = inputLines.size
    val columns = inputLines[0].length

    var addedOstacles = mutableListOf<Pair<Int, Int>>()
    val initialArea = copyOfArea(area)
    var loopControlArea: Array<Array<MutableList<Char>>> = Array(rows) { Array(columns) { mutableListOf<Char>()}}
    var inLoop = false

    init {
        findStart()
        currentRow = startRow
        currentColumn = startColumn
    }

    fun countLoopingExtraObstacles(): Int{
        var sum = 0
        area.forEachIndexed { ir, row ->
            row.forEachIndexed { ic, column ->
                addObstacle(ir, ic)
                walk()
                if (inLoop) sum += 1
            }
        }
        return sum
    }

    fun copyOfArea(ray: Array<CharArray>): Array<CharArray>{
        val newArea = Array(rows) { r -> ray[r].copyOf() }
        return newArea
    }
    fun walk(){
        while (! isOut()){
            if (inLoop) break
            when(direction){
                "^" -> walkUp()
                ">" -> walkRight()
                "v" -> walkDown()
                else -> walkLeft()
            }
        }
        steps += 1 // Add final spot
    }

    fun addObstacle(onRow: Int, onColumn: Int){
        area = copyOfArea(initialArea)
        findStart()
        area[onRow][onColumn] = '#'
        currentRow = startRow
        currentColumn = startColumn
        inLoop = false
        direction = "^"
        out = false
        steps = 0
        loopControlArea = Array(rows) { Array(columns) { mutableListOf<Char>()}}
    }

    fun addToLoopControl(){
        val spotDirectionsSoFar = loopControlArea[currentRow][currentColumn]
        if (spotDirectionsSoFar.contains(direction[0])) inLoop = true
        spotDirectionsSoFar.add(direction[0])
    }
    fun walkUp(){
        while (noObstacles(currentRow - 1, currentColumn)){
            moveUp()
        }
        switchDirection()
    }

    fun walkRight(){
        while (noObstacles(currentRow, currentColumn + 1)){
            moveRight()
        }
        switchDirection()
    }

    fun walkDown(){
        while (noObstacles(currentRow + 1, currentColumn)){
            moveDown()
        }
        switchDirection()
    }

    fun walkLeft(){
        while (noObstacles(currentRow, currentColumn - 1)){
            moveLeft()
        }
        switchDirection()
    }

    fun moveUp(){
        if (!noObstacles(currentRow - 1,currentColumn))
            switchDirection()
        else {
            if (area[currentRow][currentColumn] in (listOf('.', '^')))
                steps += 1
            area[currentRow][currentColumn] = steps.mod(10).toString()[0]
            addToLoopControl()
            currentRow -= 1
        }
    }

    fun moveRight(){
        if (!noObstacles(currentRow,currentColumn + 1))  switchDirection()
        else {
            if (area[currentRow][currentColumn] in (listOf('.', '^'))) steps += 1
            area[currentRow][currentColumn] = steps.mod(10).toString()[0]
            addToLoopControl()
            currentColumn += 1
        }
    }

    fun moveDown(){
        if (!noObstacles(currentRow + 1,currentColumn))  switchDirection()
        else {
            if (area[currentRow][currentColumn] in (listOf('.', '^'))) steps += 1
            area[currentRow][currentColumn] = steps.mod(10).toString()[0]
            addToLoopControl()
            currentRow += 1
        }
    }

    fun moveLeft(){
        if (!noObstacles(currentRow,currentColumn - 1))  switchDirection()
        else {
            if (area[currentRow][currentColumn] in (listOf('.', '^'))) steps += 1
            area[currentRow][currentColumn] = steps.mod(10).toString()[0]
            addToLoopControl()
            currentColumn -= 1
        }
    }
    fun switchDirection(){
        direction = when(direction){ "^" -> ">"; ">" -> "v"; "v" -> "<"; else -> "^"}
    }
    fun findStart(){
        var ir = -1
        var ic = -1

        for ((ir, row) in inputLines.withIndex()) {
            val ic = row.indexOf('^')

            if (ic != -1) {
                startRow = ir
                startColumn = ic
                break
            }
        }
    }

    fun noObstacles(r: Int, c: Int): Boolean{
        return r in (0..< rows) && c in (0..< columns) && slot(r, c) != "#"
    }

    fun slot(r: Int, c: Int): String{
        return area[r][c].toString()
    }

    fun isOut(): Boolean{
        return currentRow !in (0..<rows - 1) || currentColumn !in (0..<columns - 1)
    }
    override fun toString(): String {
        val s = area.map { it.concatToString() }.joinToString(separator = "\n") { it }
        return area.map { it.concatToString() }.joinToString(separator = "\n") { it }
    }

}

private operator fun String.set(currentColumn: Int, value: Char): String {
    return this.toCharArray().also { it[currentColumn] = value}.toString()
}
