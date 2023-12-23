fun main() {
    flatMapVsMap()
}

fun flatMapVsMap() {
    val dev1 = Developer("Tom", listOf("Kotlin", "Java"))
    val dev2 = Developer("Tom", listOf("Scala", "Ruby"))
    val dev3 = Developer("Tom", listOf("Javascript"))

    /**
     * map results in nesting
     * it will create a list then take the list of languages by each dev and puts the list inside the parent list
     * if that even makes sense...hahaha
     * @returns [[Kotlin, Java], [Scala, Ruby], [Javascript, PHP]]
     */
    val listMap = listOf(dev1, dev2, dev3).map { it.languages }

    /**
     * flatMap maps and flattens
     * combines all languages by each dev and puts them into a single list
     * @returns [Kotlin, Java, Scala, Ruby, Javascript, PHP]
     */

    val listFlatMap = listOf(dev1, dev2, dev3).flatMap { it.languages }

    println("Mapped list: $listMap")
    println("Flat Mapped list: $listFlatMap")
}

data class Developer(
    val name: String,
    val languages: List<String>
)