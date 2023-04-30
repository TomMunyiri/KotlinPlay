fun main() {
    square()
    removeSuffix()
}

private fun square() {
    //The long way
    val numbers = (1..10).toList()
    val squares = mutableListOf<Int>()
    for (num in numbers) {
        squares.add(num * num)
    }
    println(squares)
    //the simplified way with map
    val squareMap = (1..10).map { it * it }
    println(squareMap)
}

private fun removeSuffix() {
    data class Fruit(val name: String, val sugar: Int, val photo: String)

    val fruits = listOf(
        Fruit("mango", 12, "mango.jpg"),
        Fruit("orange", 34, "orange.jpg"),
        Fruit("passion", 45, "passion.jpg"),
        Fruit("lemon", 78, "lemon.jpg"),
        Fruit("apple", 2, "apple.jpg"),
        Fruit("peach", 16, "peach.jpg"),
        Fruit("water melon", 17, "water melon.jpg"),
    ).sortedBy(Fruit::sugar)

    println(fruits.map { it.photo.removeSuffix(".jpg") })
    println("__MORE__".removeSurrounding("__"))
}



