package fi.viware.aoc2024.day6

fun main(){
    var day = Day6("day6/src/main/res/input_test")
    println("${day.solvePuzz1()}")
    println("${day.solvePuzz2()}")

    day = Day6("day6/src/main/res/input")
    println("${day.solvePuzz1()}")
    println("${day.solvePuzz2()}")
}