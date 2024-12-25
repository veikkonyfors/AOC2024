package fi.viware.aoc2024.day9

fun main(){
    var day = Day9("day9/src/main/res/input_test")
    println("${day.solvePuzz1()}")
    day = Day9("day9/src/main/res/input_test")
    println("${day.solvePuzz2()}")

    day = Day9("day9/src/main/res/input")
    println("${day.solvePuzz1()}")
    day = Day9("day9/src/main/res/input")
    println("${day.solvePuzz2()}")
}