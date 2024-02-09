import java.lang.IllegalArgumentException

fun main() {
    val myArray = intArrayOf(105, 5, 9, 23, 45, 67, 94, 2456, 456)
    getMax(myArray)
    getMin(myArray)
    reverseArray(myArray)
    getMinimumAbsoluteDifference(myArray)
}

fun getMax(myArray: IntArray) {
    var currentMax = myArray[0]
    for (i in myArray) {
        if (i > currentMax) {
            currentMax = i
        }
    }
    println("Max: $currentMax")
}

fun getMin(myArray: IntArray) {
    var currentMin = myArray[0]
    for (i in myArray) {
        if (i < currentMin) {
            currentMin = i
        }
    }
    println("Min: $currentMin")
}

fun reverseArray(myArray: IntArray) {
    println("Reversed order: ${myArray.reversedArray().toList()}")
}

fun getMinimumAbsoluteDifference(myArray: IntArray) {
    if (myArray.size < 2) {
        throw IllegalArgumentException()
    }
    // Sort the array to simplify the comparison
    myArray.sort()

    // Initialize the minimum absolute difference with the maximum possible value
    var minDifference = Int.MAX_VALUE

    // Iterate through the array and compare adjacent elements
    for (i in 0 until myArray.size - 1) {
        val currentDifference = kotlin.math.abs(myArray[i] - myArray[i + 1])
        if (currentDifference < minDifference) {
            minDifference = currentDifference
        }
    }
    println("Minimum absolute difference: $minDifference")
}