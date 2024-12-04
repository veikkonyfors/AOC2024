package fi.viware.aoc2024.day2

import kotlin.math.abs

class Report(val levelLine: String) {

    val levelInts: List<Int> = levelLine.split(" ").map { it.toInt() }

    var dampenedReport: Report = this

    fun isIncreasing(): Boolean{
        var previousLevel = levelInts[0]
        levelInts.forEachIndexed { index, it ->
            if(index != 0 && it <= previousLevel) return false
            previousLevel = it
        }
        return true
    }
    fun isIncreasingDampenedAndTight(): Boolean{

        var levelIntsList = levelInts.map { it }.toMutableList()
        var dampenedLevelIntsList = levelIntsList.map{it}.toMutableList()
        levelIntsList.forEachIndexed { index, it ->
            dampenedLevelIntsList.removeAt(index)
            dampenedReport = Report(dampenedLevelIntsList.joinToString(separator = " "))
            if (dampenedReport.isIncreasing() && dampenedReport.isTight()) return true
            dampenedLevelIntsList = levelIntsList.map{it}.toMutableList()
        }
        return false
    }

    fun isDecreasing(): Boolean{
        var previousLevel = levelInts[0]
        levelInts.forEachIndexed { index, it ->
            if(index != 0 && it >= previousLevel) return false
            previousLevel = it
        }
        return true
    }
    fun isDecreasingDampenedAndTight(): Boolean{

        val levelIntsList = levelInts.map { it }.toMutableList()
        var previousLevel = levelIntsList[0]
        var dampenedLevelIntsList = levelIntsList.map{it}.toMutableList()

        levelIntsList.forEachIndexed { index, it ->
                dampenedLevelIntsList.removeAt(index)
                dampenedReport = Report(dampenedLevelIntsList.joinToString(separator = " "))
                if (dampenedReport.isDecreasing() && dampenedReport.isTight()) return true
                dampenedLevelIntsList = levelIntsList.map{it}.toMutableList()
            previousLevel = it
        }
        return false
    }

    fun isTight(): Boolean{
        var previousLevel = levelInts[0]
        levelInts.forEachIndexed { index, it ->
            if(index != 0 && it == previousLevel ) return false
            if(abs(it - previousLevel) > 3) return false
            previousLevel = it
        }
        return true
    }

    fun isTightDampened(): Boolean{
        val dampenedLevelInts = levelInts.map { it }.toMutableList()
        var previousLevel = levelInts[0]
        levelInts.forEachIndexed { index, it ->
            if(index != 0 && it == previousLevel ) {
                dampenedLevelInts.removeAt(index)
                dampenedReport = Report(dampenedLevelInts.joinToString(separator = " "))
                return dampenedReport.isTight()
            }

            if(index != 0 && abs(it - previousLevel) > 3) {
                dampenedLevelInts.removeAt(when(index) {1 -> 0; else -> index}) // 3 10 11 or 3 4 11 5 6 or 3 4 5 11
                dampenedReport = Report(dampenedLevelInts.joinToString(separator = " "))
                return dampenedReport.isTight()
            }
            previousLevel = it
        }
        return true
    }

    fun isSafe(): Boolean{
        return (isDecreasing() || isIncreasing()) && isTight()
    }

    fun isSafeDampened(): Boolean{

        var s = isSafe()
        if (s) return true

        var i = isIncreasing()
        if (i) return this.isTightDampened()
        i = isIncreasingDampenedAndTight()
        if (i) return true

        var d = isDecreasing()
        if (d) return  this.isTightDampened()
        d =isDecreasingDampenedAndTight()
        if(d) return true

        return false // Wasn't increasing or decreasing, not even as dampened
    }
    override fun toString(): String {
        return levelLine
    }
}

