package fi.viware.aoc2024.day2

fun main(){
    var day2 = Day2("day4/src/main/res/input")
    var s = day2.safeCount()
    println("$s")
    s = day2.safeCountDampened()
    println("$s")
}