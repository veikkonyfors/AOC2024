package fi.viware.aoc2024.day4

fun main(){
    var day4 = Day4("day4/src/main/res/input_test")
    var s = day4.xmasGrid.countXmas()
    println("$s")

    day4 = Day4("day4/src/main/res/input")
    s = day4.xmasGrid.countXmas()
    println("$s")
}