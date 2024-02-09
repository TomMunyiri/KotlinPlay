import java.lang.IllegalArgumentException

fun main() {
    //val myArray = intArrayOf(105, 5, 9, 23, 45, 67, 94, 2456, 456)
    val myArray = intArrayOf(-59, -36, -13, 1, -53, -92, -2, -96, -54, 75)
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
    //kotlin extension
    //println("Reversed order: ${myArray.reversedArray().toList()}")

    //raw implementation
    val result = IntArray(myArray.size) //this will create an int array of size n (size passed as a parameter) with all elements initialized to 0
    val lastIndex = myArray.size - 1
    for (i in 0..lastIndex) {
        /*replace current item at lastIndex -1 (traverse array from backwards) with current item at index i in
        our loop since we started looping from the front*/
        result[lastIndex - i] = myArray[i]
    }
    println(result.toList())
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