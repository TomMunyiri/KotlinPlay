fun main() {
    bodmas1()
    bodmas2()
}

fun bodmas1() {
    val x = 3 * (2 + 5)
    println("Result 1: $x")
}

fun bodmas2() {
    operator fun Int.invoke(other: Int) = this * other
    val x = 3(2 + 5)
    println("Result 2: $x")
}