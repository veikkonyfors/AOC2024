package fi.viware.day7

fun main(){
    var day = Day7("day7/src/main/res/input_test")
    println("${day.solvePuzz1()}")
    println("${day.solvePuzz2()}")

    day = Day7("day7/src/main/res/input")
    println("${day.solvePuzz1()}")
    println("${day.solvePuzz2()}")
}