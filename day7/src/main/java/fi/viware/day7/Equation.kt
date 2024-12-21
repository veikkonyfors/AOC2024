package fi.viware.day7

class Equation(val calcLine: String) {
    var result: Long
    var operands: List<Int>
    var operatorPermutations: List<String>
    val operatorPermutations2: List<String>
    val allowedOperators: List<String>
    val allowedOperators2: List<String>

    init {
        val re = """(\d+): ([\d\s]+)""".toRegex()
        val matchResult = re.matchEntire(calcLine)
        result = matchResult!!.groupValues[1].toLong()
        operands = matchResult!!.groupValues[2].split(" ").map { it.toInt() }
        allowedOperators = listOf("+", "*")
        allowedOperators2 = listOf("+", "*","|")
        operatorPermutations = generatePermutations(operands.size - 1, allowedOperators )
        operatorPermutations2 = generatePermutations(operands.size - 1, allowedOperators2 )
    }

    fun verifyEquation(): Boolean{
        operatorPermutations2.forEach { operpermutation ->
            var res = operands[0].toLong()
            operands.forEachIndexed { io, o ->
                if (io == 0) return@forEachIndexed
                when(operpermutation[io - 1]){
                    '+' -> res += o
                    '|' -> res = res*Math.pow(10.0, o.toString().length.toDouble()).toInt()+o
                    else -> res *= o
                }
            }
            if (res == result) return true
            if (res > result) return@forEach
        }
        return false
    }

    fun generatePermutations(length: Int, allowedOperators: List<String>): List<String> {
        val extendedPermutations = mutableListOf<String>()
        if (length == 1) return allowedOperators
        else {
            val smallerPermutations = generatePermutations(length - 1, allowedOperators)

            for (perm in smallerPermutations) {
                for (char in allowedOperators) {
                    extendedPermutations.add(perm + char)
                }
            }
        }
        return extendedPermutations
    }

    override fun toString(): String {
        return "$result"+": " +operands.joinToString(separator = " ") { it.toString() } + "; " + operatorPermutations.joinToString(separator = " "){ it }
    }
}