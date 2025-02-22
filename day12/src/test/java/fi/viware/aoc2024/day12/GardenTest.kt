package fi.viware.aoc2024.day12

import org.junit.Assert.*
import org.junit.Test

class GardenTest(){

    @Test
    fun puzz1Test() {

        var day = Day12("src/main/res/input_test")
        var s = day.garden.gardenGrid.joinToString("\n") { it.joinToString("") }
        println("$s")
        assertEquals("RRRRIICCFF\nRRRRIICCCF\nVVRRRCCFFF\nVVRCCCJFFF\nVVVVCJJCFE\nVVIVCCJJEE\nVVIIICJJEE\nMIIIIIJJEE\nMIIISIJEEE\nMMMISSJEEE",s)

        var result = day.garden.countDistinctGroups('I')
        s = "${result.size} ${result.joinToString(separator = ", ") {
            "${it.plant}:${it.size}:${it.perimeter}:${it.cost}"
        }}"
        println("$s")
        assertEquals("2 I:4:8:32, I:14:22:308", s)

        result = day.garden.countDistinctGroups('I')
        s = "${result.size} ${result.joinToString(separator = ", ") { 
            "${it.plant}:${it.size}:${it.perimeter}:${it.cost}"
        }}"
        println("$s")
        assertEquals("2 I:4:8:32, I:14:22:308", s)

        s = day.garden.distinctPlants().toString()
        println("$s")
        assertEquals("[R, I, C, F, V, J, E, M, S]", s)

        result = day.garden.countDistinctGroups('R')
        s = "${result.size} ${result.joinToString(separator = ", ") {
            "${it.plant}:${it.size}:${it.perimeter}:${it.cost}"
        }}"
        println("$s")
        assertEquals("1 R:12:18:216", s)

        var results = mutableListOf<Garden.GroupInfo>()
        day.garden.distinctPlants().forEach {
            results.addAll(day.garden.countDistinctGroups(it))
        }
        var i = results.sumOf {
            it.cost
        }
        println("$i")
        assertEquals(1930, i)

        day = Day12("src/main/res/input")
        results = mutableListOf<Garden.GroupInfo>()
        day.garden.distinctPlants().forEach {
            results.addAll(day.garden.countDistinctGroups(it))
        }
        i = results.sumOf {
            it.cost
        }
        println("$i")
        assertEquals(1370258, i)
    }

    @Test
    fun puzz2Test() {

        var day = Day12("src/main/res/input_test")
        var s = day.garden.gardenGrid.joinToString("\n") { it.joinToString("") }
        println("$s")
        assertEquals("RRRRIICCFF\nRRRRIICCCF\nVVRRRCCFFF\nVVRCCCJFFF\nVVVVCJJCFE\nVVIVCCJJEE\nVVIIICJJEE\nMIIIIIJJEE\nMIIISIJEEE\nMMMISSJEEE",s)

        var result = day.garden.countDistinctGroups('I')
        s = "${result.size} ${result.joinToString(separator = ", ") {
            "${it.plant}:${it.size}:${it.perimeter}:${it.cost}"
        }}"
        println("$s")
        assertEquals("2 I:4:8:32, I:14:22:308", s)
        var b: Boolean

        b = day.garden.nwCorner(0, 0, 'R')
        //println("$b")
        assertEquals(true,b)

        b = day.garden.nwCorner(0, 1, 'R')
        //println("$b")
        assertEquals(false,b)

        b = day.garden.neCorner(0, 3, 'R')
        //println("$b")
        assertEquals(true,b)

        b = day.garden.neCorner(0, 2, 'R')
        //println("$b")
        assertEquals(false,b)

        b = day.garden.neCorner(0, 5, 'R')
        //println("$b")
        assertEquals(false,b)

        b = day.garden.seCorner(2, 4, 'R')
        //println("$b")
        assertEquals(true,b)

        b = day.garden.neCorner(2, 4, 'R')
        //println("$b")
        assertEquals(true,b)

        b = day.garden.seCorner(3, 2, 'R')
        //println("$b")
        assertEquals(true,b)

        b = day.garden.seCorner(0, 2, 'R')
        //println("$b")
        assertEquals(false,b)

        b = day.garden.swCorner(3, 2, 'R')
        //println("$b")
        assertEquals(true,b)

        b = day.garden.seCorner(3, 2, 'R')
        //println("$b")
        assertEquals(true,b)

        b = day.garden.seCorner(0, 0, 'R')
        //println("$b")
        assertEquals(false,b)

        b = day.garden.swInteriorCorner(2, 3, 'R')
        //println("$b")
        assertEquals(true,b)

        b = day.garden.nwInteriorCorner(2, 3, 'R')
        //println("$b")
        assertEquals(false,b)


        b = day.garden.neInteriorCorner(1, 2, 'R')
        //println("$b")
        assertEquals(true,b)

        b = day.garden.nwInteriorCorner(1, 2, 'R')
        //println("$b")
        assertEquals(false,b)

        b = day.garden.swInteriorCorner(1, 2, 'R')
        //println("$b")
        assertEquals(false,b)

        b = day.garden.neInteriorCorner(2, 2, 'R')
        //println("$b")
        assertEquals(false,b)

        b = day.garden.seInteriorCorner(7, 2, 'I')
        //println("$b")
        assertEquals(true,b)

        b = day.garden.seInteriorCorner(2, 2, 'R')
        //println("$b")
        assertEquals(false,b)

        b = day.garden.neInteriorCorner(4, 6, 'J')
        //println("$b")
        assertEquals(true,b)

        b = day.garden.swInteriorCorner(2, 3, 'R')
        //println("$b")
        assertEquals(true,b)

        var plant = 'R'
        result = day.garden.countDistinctGroups(plant)
        var i = result.size
        s = ""
        assertEquals(1, i)
        println("$plant-kirjaimen ryhmiä: ${result.size}")
        result.forEachIndexed { index, group ->
            s = "Ryhmä ${index + 1} ${group.plant}: koko = ${group.size}, ääriviivan pituus = ${group.perimeter}, reunoja = ${group.sides}"
            println("$s")
            assertEquals("Ryhmä 1 R: koko = 12, ääriviivan pituus = 18, reunoja = 10", s)
        }

        plant = 'I'
        result = day.garden.countDistinctGroups(plant)
        i = result.size
        s = ""
        assertEquals(2, i)
        println("$plant-kirjaimen ryhmiä: ${result.size}")
        result.forEachIndexed { index, group ->
            s += "Ryhmä ${index + 1} ${group.plant}: koko = ${group.size}, ääriviivan pituus = ${group.perimeter}, reunoja = ${group.sides}\n"
        }
        println("$s")
        assertEquals("Ryhmä 1 I: koko = 4, ääriviivan pituus = 8, reunoja = 4\nRyhmä 2 I: koko = 14, ääriviivan pituus = 22, reunoja = 16\n", s)

        result = mutableListOf()
        day.garden.gardenGrid.flatMap { it.toList() }.toSet().forEach {
            result.addAll(day.garden.countDistinctGroups(it))
        }

        s = ""
        i = 0
        result.forEachIndexed { index, group ->
            s += "Ryhmä ${index + 1} ${group.plant}: koko = ${group.size}, ääriviivan pituus = ${group.perimeter}, reunoja = ${group.sides}, discountedPrice = ${group.discountedPrice}\n"
            i += group.discountedPrice
        }
        println("$s")
        assertEquals("Ryhmä 1 R: koko = 12, ääriviivan pituus = 18, reunoja = 10, discountedPrice = 120\n" +
                "Ryhmä 2 I: koko = 4, ääriviivan pituus = 8, reunoja = 4, discountedPrice = 16\n" +
                "Ryhmä 3 I: koko = 14, ääriviivan pituus = 22, reunoja = 16, discountedPrice = 224\n" +
                "Ryhmä 4 C: koko = 14, ääriviivan pituus = 28, reunoja = 22, discountedPrice = 308\n" +
                "Ryhmä 5 C: koko = 1, ääriviivan pituus = 4, reunoja = 4, discountedPrice = 4\n" +
                "Ryhmä 6 F: koko = 10, ääriviivan pituus = 18, reunoja = 12, discountedPrice = 120\n" +
                "Ryhmä 7 V: koko = 13, ääriviivan pituus = 20, reunoja = 10, discountedPrice = 130\n" +
                "Ryhmä 8 J: koko = 11, ääriviivan pituus = 20, reunoja = 12, discountedPrice = 132\n" +
                "Ryhmä 9 E: koko = 13, ääriviivan pituus = 18, reunoja = 8, discountedPrice = 104\n" +
                "Ryhmä 10 M: koko = 5, ääriviivan pituus = 12, reunoja = 6, discountedPrice = 30\n" +
                "Ryhmä 11 S: koko = 3, ääriviivan pituus = 8, reunoja = 6, discountedPrice = 18\n", s)
        assertEquals(1206, i)

        day = Day12("src/main/res/input_test")
        i = day.garden.totalDiscountedCost()
        println("$i")
        assertEquals(1206, i)

        day = Day12("src/main/res/input")
        i = day.garden.totalDiscountedCost()
        println("$i")
        assertEquals(805814, i)

    }

}