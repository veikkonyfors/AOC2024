package fi.viware.aoc2024.day4

class XmasGrid(val xmasGridLines: List<String>) {

    var xmasGridArray = xmasGridLines.toTypedArray()
    var transposedXmasGridArray = transpose()
    var diagonalizedXmasGridArray = diagonalize()

    val xmasString = "XMAS"

    fun getRow(rownum: Int): Row{
        return Row(xmasGridArray[rownum])
    }

    fun getColumn(colnum: Int): Row{
        return Row(transposedXmasGridArray[colnum])
    }

    fun countXmasOnRows(rows: Array<String>): Int{
        var count = 0
        rows.forEach {
            val oneRow = Row(it)
            count += oneRow.countXmas()
        }
        return count
    }

    fun countColumns(): Int{
        return 0
    }

    fun countDiagonals(): Int{
        return 0
    }

    fun countXmas(): Int{
        var xmasCount = 0

        xmasCount += countXmasOnRows(xmasGridArray)
        xmasCount += countXmasOnRows(transposedXmasGridArray)
        xmasCount += countXmasOnRows(diagonalizedXmasGridArray)

        return xmasCount
    }

    fun transpose(): Array<String> {
        val rows = xmasGridArray.size
        val columns = xmasGridArray[0].length
        val transposedArrayOfStrins = Array(columns) { String(CharArray(rows)) }

        for (i in xmasGridArray.indices) {
            for (j in xmasGridArray[i].indices) {
                transposedArrayOfStrins[j] = transposedArrayOfStrins[j].substring(0, i) + xmasGridArray[i][j] + transposedArrayOfStrins[j].substring(i + 1)
            }
        }

        return transposedArrayOfStrins
    }

    fun diagonalize(): Array<String> {
        val rows = xmasGridArray.size
        val columns = xmasGridArray[0].length

        val diagonals = mutableListOf<String>()

        for (i in 0 until rows) {
            diagonals.add(getOneDiagonalSE(i, 0).toString())  // SE diagonals on left side
        }

        for (j in 1 until columns) {
            diagonals.add(getOneDiagonalSE(0, j).toString())  // SE diagonals on right side
        }

        for (i in 0 until rows) {
            diagonals.add(getOneDiagonalSW(i, xmasGridArray[0].length-1).toString())  // SW diagonals on left side
        }

        for (j in columns - 2 downTo  0 ) {
            diagonals.add(getOneDiagonalSW(0, j).toString())  // SE diagonals on right side
        }
        return diagonals.toTypedArray()
    }

    fun getOneDiagonalSE(r: Int, c: Int): Row {
        val diagonal = StringBuilder()
        var i = r
        var j = c

        while (i < xmasGridArray.size && j < xmasGridArray[0].length) {
            diagonal.append(xmasGridArray[i][j])
            i++
            j++
        }

        val s = diagonal.toString()
        val ret = Row(diagonal.toString())

        return ret
    }

    fun getOneDiagonalSW(r: Int, c: Int): Row {
        val diagonal = StringBuilder()
        var i = r
        var j = c

        while (i < xmasGridArray.size && j >= 0) {
            diagonal.append(xmasGridArray[i][j])
            i++
            j--
        }

        val s = diagonal.toString()
        val ret = Row(diagonal.toString())

        return ret
    }

    fun diagonalToString(): String {
        return diagonalizedXmasGridArray.joinToString(separator = "\n") { "$it" }
    }

    fun transposeToString(): String {
        return transposedXmasGridArray.joinToString(separator = "\n") { "$it" }
    }
    override fun toString(): String {
        return xmasGridArray.joinToString(separator = "\n") { "$it" }
    }



}