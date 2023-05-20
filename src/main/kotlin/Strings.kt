fun main() {
    joinToString()
    removeBeforeAfter()
}

private fun joinToString() {
    data class Fruit(val name: String, val sugar: Int)

    val fruits = listOf(
        Fruit("mango", 12),
        Fruit("orange", 34),
        Fruit("passion", 45),
        Fruit("lemon", 78),
        Fruit("apple", 2),
        Fruit("peach", 16),
        Fruit("water melon", 17),
    ).sortedBy(Fruit::sugar)

    val joinFruits = fruits.reversed().joinToString(
        separator = ",", prefix = "\uD83D\uDE18 = [", postfix = "]", limit = 3, truncated = "MORE", transform = Fruit::name
    )

    println(joinFruits)
}

private fun removeBeforeAfter() {
    val myString = "404404003001"
    var newString = ""
    newString = myString.substring(3, myString.length - 3)
    println(newString)
}