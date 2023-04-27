fun main() {
    square()
}

fun square() {
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

