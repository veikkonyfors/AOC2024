package fi.viware.aoc2024.day10

fun main(){
    var day = Day10("day10/src/main/res/input_test")
    println("${day.solvePuzz1()}")
    println("${day.solvePuzz2()}")

    day = Day10("day10/src/main/res/input")
    println("${day.solvePuzz1()}")
    println("${day.solvePuzz2()}")
}