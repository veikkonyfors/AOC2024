package fi.viware.aoc2024.day5

fun main(){
    var day5 = Day5("day5/src/main/res/input_test")
    println("${day5.solvePuzz1()}")

    day5 = Day5("day5/src/main/res/input")
    println("${day5.solvePuzz2()}")
}