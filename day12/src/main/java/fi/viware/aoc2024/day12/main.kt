package fi.viware.aoc2024.day12

fun main(){
    var day = Day12("day12/src/main/res/input_test")
    println("${day.solvePuzz1()}")
    println("${day.solvePuzz2()}")

    day = Day12("day12/src/main/res/input")
    println("${day.solvePuzz1()}")
    println("${day.solvePuzz2()}")
}