package fi.viware.aoc2024.day6

import org.junit.Assert.*
import org.junit.Test

class Day6Test(){

    @Test
    fun  puzz2Tests() {
        var area = Day6("src/main/res/input_test").area
        var s = ""
        var i = 0

        s = area.toString()
        //println("$s")
        assertEquals("....#.....\n.........#\n..........\n..#.......\n.......#..\n..........\n.#..^.....\n........#.\n#.........\n......#...",s)
        s = "("+area.startRow+","+area.startColumn+")"
        //println("$s\n")
        assertEquals("(6,4)",s)

        area.addObstacle(6, 3)
        s = area.toString()
        //println("$s\n")
        assertEquals("....#.....\n.........#\n..........\n..#.......\n.......#..\n..........\n.#.#^.....\n........#.\n#.........\n......#...",s)

        area.walkUp()
        area.walkRight()
        area.walkDown()
        area.walkLeft()
        s = area.toString()
        //println("$s\n")
        assertEquals("....#.....\n....67890#\n....5...1.\n..#.4...2.\n....3..#3.\n....2...4.\n.#.#18765.\n........#.\n#.........\n......#...",s)

        area = Day6("src/main/res/input_test").area
        area.addObstacle(6, 3)
        area.walkUp() // Testin isInloop, addloopcontrol in moveup
        area.walkRight()
        area.walkDown()
        area.walkLeft()
        area.walk()
        s = area.toString()
        //println("$s\n")
        assertEquals("....#.....\n....67890#\n....8...1.\n..#.8...2.\n....8..#3.\n....8...4.\n.#.#88765.\n........#.\n#.........\n......#...",s)
        s = area.loopControlArea.joinToString("\n") { it.joinToString(",") }
        //println("$s")
        assertEquals("[],[],[],[],[],[],[],[],[],[]\n[],[],[],[],[>],[>],[>],[>],[v],[]\n[],[],[],[],[^, ^],[],[],[],[v],[]\n[],[],[],[],[^, ^],[],[],[],[v],[]\n[],[],[],[],[^, ^],[],[],[],[v],[]\n[],[],[],[],[^, ^],[],[],[],[v],[]\n[],[],[],[],[^, ^],[<],[<],[<],[<],[]\n[],[],[],[],[],[],[],[],[],[]\n[],[],[],[],[],[],[],[],[],[]\n[],[],[],[],[],[],[],[],[],[]",s)

        area = Day6("src/main/res/input_test").area
        area.addObstacle(7, 6)
        area.walk()
        s = area.toString()
        //println("$s\n")
        assertEquals("....#.....\n....67890#\n....5...1.\n..#.4...2.\n..23345#3.\n..1.2.6.4.\n.#0666665.\n......#.#.\n#.........\n......#...",s)
        s = area.loopControlArea.joinToString("\n") { it.joinToString(",") }
        //println("$s")
        assertEquals("[],[],[],[],[],[],[],[],[],[]\n[],[],[],[],[>],[>],[>],[>],[v],[]\n[],[],[],[],[^],[],[],[],[v],[]\n[],[],[],[],[^],[],[],[],[v],[]\n[],[],[>],[>],[^, >],[>],[v],[],[v],[]\n[],[],[^],[],[^],[],[v],[],[v],[]\n[],[],[^],[<, <],[^, <, <],[<, <],[<, <],[<],[<],[]\n[],[],[],[],[],[],[],[],[],[]\n[],[],[],[],[],[],[],[],[],[]\n[],[],[],[],[],[],[],[],[],[]",s)

        area = Day6("src/main/res/input_test").area
        area.addObstacle(9, 7)
        area.walk()
        s = area.toString()
        //println("$s\n") //assertEquals(".....#..... ....67890# ....5...1. ..#.4...2. ..23345#3. ..1.2.6.4. .#0988665. .4567889#. #3000000.. ......##..",s)
        s = area.loopControlArea.joinToString("\n") { it.joinToString(",") }
        //println("$s")
        assertEquals("[],[],[],[],[],[],[],[],[],[]\n[],[],[],[],[>],[>],[>],[>],[v],[]\n[],[],[],[],[^],[],[],[],[v],[]\n[],[],[],[],[^],[],[],[],[v],[]\n[],[],[>],[>],[^, >],[>],[v],[],[v],[]\n[],[],[^],[],[^],[],[v],[],[v],[]\n[],[],[^],[<],[^, <],[<],[<, v],[<],[<],[]\n[],[>],[>],[>],[>],[>],[v, >],[v],[],[]\n[],[^],[<, <],[<, <],[<, <],[<, <],[<, <],[<],[],[]\n[],[],[],[],[],[],[],[],[],[]",s)

        area = Day6("src/main/res/input_test").area
        i = area.countLoopingExtraObstacles()
        println("$i")
        assertEquals(6,i)

        area = Day6("src/main/res/input").area
        i = area.countLoopingExtraObstacles()
        println("$i")
        assertEquals(6,i)

    }


/*
2090 too high
 */

    @Test
    fun  puzz1Tests(){
        var area = Day6("src/main/res/input_test").area
        var s = ""
        var i = 0

        s = area.toString()
        //println("$s")
        assertEquals("....#.....\n.........#\n..........\n..#.......\n.......#..\n..........\n.#..^.....\n........#.\n#.........\n......#...",s)
        s = "("+area.startRow+","+area.startColumn+")"
        //println("$s\n")
        assertEquals("(6,4)",s)

        area.walkUp()
        s = area.toString()
        //println("$s\n")
        assertEquals("....#.....\n.........#\n....5.....\n..#.4.....\n....3..#..\n....2.....\n.#..1.....\n........#.\n#.........\n......#...",s)

        area.walkRight()
        s = area.toString()
        //println("$s\n")
        assertEquals("....#.....\n....6789.#\n....5.....\n..#.4.....\n....3..#..\n....2.....\n.#..1.....\n........#.\n#.........\n......#...",s)

        area.walkDown()
        s = area.toString()
        //println("$s\n")
        assertEquals("....#.....\n....67890#\n....5...1.\n..#.4...2.\n....3..#3.\n....2...4.\n.#..1.....\n........#.\n#.........\n......#...",s)

        area.walkLeft()
        s = area.toString()
        //println("$s\n")
        assertEquals("....#.....\n....67890#\n....5...1.\n..#.4...2.\n....3..#3.\n....2...4.\n.#.988765.\n........#.\n#.........\n......#...",s)

        area = Day6("src/main/res/input_test").area
        area.walk()
        s = area.toString()
        //println("$s\n")
        assertEquals("....#.....\n....67890#\n....5...1.\n..#.4...2.\n..23345#3.\n..1.2.6.4.\n.#0988665.\n.4567889#.\n#3210980..\n......#...",s)

        i = area.steps
        //println("$i")
        assertEquals(41, i)

    }
}