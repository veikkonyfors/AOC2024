package fi.viware.aoc2024.day5

class Update(val updateLine: String) {
    val pages = updateLine.split(",")

    fun sortPages(rules: List<String>): Update{

        val comparator: Comparator<String> = Comparator { a, b ->
            when {
                "$a|$b" in rules -> -1
                "$b|$a" in rules -> 1
                else -> 0
            }
        }

        val sortedPages = pages.sortedWith(comparator)

        return Update(sortedPages.toString())
    }

    fun isCorrectlyOrdered(rulesForaPage: List<String>): Boolean{
        var b: Boolean = true

        run breaking@{
            pages.forEachIndexed { indexOfPage, p ->
                // If any of the pages given in rulesForaPage exist prior to this page on pages
                rulesForaPage.forEach { r ->
                    // if ruler page exist on the left of of this page
                    val rulePage1 = r.split("|")[0]
                    val rulePage2 = r.split("|")[1]
                    if (p == rulePage1) { // If this rule applies on this page
                        val rulerPageIndexOnUpdate = pages.indexOf(rulePage2)
                        if (rulerPageIndexOnUpdate != -1 && (rulerPageIndexOnUpdate < indexOfPage)) {
                            b = false
                            return@breaking
                        }
                    }
                }
            }
        }
        return b
    }

    fun getMiddleNumber(): Int{
        val pages = updateLine.split(",")
        val midIndex = pages.size/2
        return pages[midIndex].trim().toInt()
    }
    override fun toString(): String {
        return updateLine
    }
}