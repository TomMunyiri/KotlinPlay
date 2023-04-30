fun main() {
    square()
    removeSuffix()
    take()
    drop()
    partition()
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

data class Fruit(val name: String, val sugar: Int, val photo: String)

val fruits = listOf(
    Fruit("mango", 12, "mango.jpg"),
    Fruit("orange", 34, "orange.jpg"),
    Fruit("passion", 4, "passion.jpg"),
    Fruit("lemon", 78, "lemon.jpg"),
    Fruit("apple", 2, "apple.jpg"),
    Fruit("peach", 16, "peach.jpg"),
    Fruit("water melon", 17, "water melon.jpg"),
).sortedBy(Fruit::sugar)

private fun removeSuffix() {
    println(fruits.map { it.photo.removeSuffix(".jpg") })
    println("__MORE__".removeSurrounding("__"))
}

private fun take() {
    println("Take 2 = ${fruits.take(2)}")
    println("Take Last = ${fruits.takeLast(3)}")
}

private fun drop() {
    fruits.drop(4)
    println(fruits)
    fruits.dropLast(2)
    println(fruits)
}

private fun partition() {
    val (sweet, superSweet) = fruits.partition { it.sugar < 10 }
    println(sweet)
    println(superSweet)
}



