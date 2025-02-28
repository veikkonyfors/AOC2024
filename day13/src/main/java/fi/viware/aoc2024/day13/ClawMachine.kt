package fi.viware.aoc2024.day13

import java.lang.Integer.min

class ClawMachine(val aMoves: Pair<Int, Int>, val bMoves: Pair<Int, Int>, val prizeXY: Pair<Int, Int>) {

    fun bMax(): Int{
        val xMax: Int = prizeXY.first / (bMoves.first)
        val yMax: Int = prizeXY.second / (bMoves.second)
        return min(xMax, yMax)
    }

    fun cheapestPushes(bMax: Int): Pair<Int, Int>{
        var ret = 0 to 0
        for (i in bMax downTo  0) {

            val bWorthx = i * bMoves.first
            val aWorthx = prizeXY.first - bWorthx
            if (aWorthx % aMoves.first != 0) continue
            val aCountx = aWorthx / aMoves.first
            val bCountx = i
            val yVal = bCountx * bMoves.second + aCountx * aMoves.second
            if (yVal != prizeXY.second) continue
            ret = aCountx to bCountx
        }
        return ret
    }

    fun cost(cheapestPushes: Pair<Int, Int>): Int{
        return cheapestPushes.first * 3 + cheapestPushes.second * 1
    }
}