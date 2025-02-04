package fi.viware.aoc2024.day11

fun main(){
    var day = Day11("day11/src/main/res/input_test")
    println("${day.solvePuzz1(25)}")
    println("${day.solvePuzz2(75)}")

    day = Day11("day11/src/main/res/input")
    println("${day.solvePuzz1(25)}")
    println("${day.solvePuzz2(75)}")
}