import java.util.TreeMap

fun main() {
    //for loop with range. this will include even 10 in the loop
    for (x in 1..10) println(x)

    //this will exclude 10
    for (x in 1 until 10) println(x)

    for (x in 1..10 step 2) println(x)

    for (x in 10 downTo 1) println(x)

    val ages = TreeMap<String, Int>()
    ages["Tom"] = 25
    ages["Liz"] = 24
    ages["Eunice"] = 55
    ages["Edwin"] = 30
    ages["Rocky"] = 89
    for ((name, age) in ages) {
        println("Name: $name. Age: $age")
    }

    val numbers = listOf(1, 2, 5, 90, 6, 89, 30)
    for ((index, element) in numbers.withIndex()) {
        println("$element is at index $index")
    }

    numbers.forEachIndexed { index, number ->
        println("$number at index $index")
    }

    //ranges can be of any type, int, characters...as long as the type can implement the Comparable interface (can be compared)
    var charactersRange = 'a'..'z'
    var numbersRange = 1..10
}