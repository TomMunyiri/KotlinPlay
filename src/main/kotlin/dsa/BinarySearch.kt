package dsa

fun findMiddleElement(intArray: IntArray): Int {
    val right = intArray.indexOf(intArray.last())
    val left = intArray.indexOf(intArray.first())
    //use formula to get middle element => M = L + (R - L )/2...THIS FORMULA WILL RETURN THE POSITION OF THE MIDDLE ELEMENT
    val middle = intArray[left + ((right - left) / 2)]
    println("Middle: $middle")
    return middle
}

fun main() {
    //findMiddleElement()
    //println("Is it square: ${checkSquareRoot(square = 4, squareRoot = 2)}")
    val array = intArrayOf(1, 4, 57, 89, 45, 67, 34)
    println("Find my element: Index in array => [${binarySearch(array.sortedArray(), 34)}]")
    println("Square root is: ${checkIfSquare(9)}")
    println("First value: ${firstValue(array.sortedArray(), 88)}")
}

/**
 * This implementation assumes: 1.Array is sorted 2.Array does not have duplicates
 * To ensure this function aligns to the single responsibility principle, do sorting and removing duplicates
 * in a separate function
 * @param intArray
 * @param target
 * @return The index of the target value if found, or -1 if the target is not in the array.
 */
/**
Time Complexity
The binary search algorithm repeatedly divides the search range in half, reducing the problem size exponentially.

Initial Range: The range starts as n, where n is the size of the array.
Halving: At each iteration of the while loop, the range is halved:
First iteration:
𝑛 → 𝑛/2
Second iteration:
𝑛/2 → 𝑛/4
And so on....
Until the range reduces to a single element or the target is found.
The number of iterations required is proportional to the number of times you can divide n by 2, which is
𝑂(log n)
Thus, the time complexity is:
O(log n)

Space Complexity
The space complexity is determined by the additional memory used by the algorithm:

Input Storage:
The algorithm works directly on the input array intArray. No additional copies are made, so input storage is
𝑂(1)
Variables:
The algorithm uses a few variables (left, right, middle, and the return value), all of which occupy constant space.
No Recursion:
The algorithm uses an iterative approach rather than recursion, so there’s no additional memory overhead for function call stacks.
Thus, the space complexity is:
O(1)

 */

fun binarySearch(intArray: IntArray, target: Int): Int {
    var left = 0
    var right = intArray.size - 1
    while (left <= right) {
        /**
         * gets the position of the middle element in array
         * M = L + ( R - L ) / 2
         */
        val middle = left + (right - left) / 2
        when {
            intArray[middle] == target -> return middle
            intArray[middle] < target -> left = middle + 1
            else -> right = middle - 1
        }
    }
    return -1
}

fun checkIfSquare(target: Int): Boolean {
    /**
     * gets the position of the middle element in array
     * M = L + ( R - L ) / 2
     */

    var left = 0
    var right = target

    //no array here, we create a range of elements

    while (left <= right) {
        // Calculate the middle of the range
        val middle = left + (right - left) / 2
        println("Middle $middle")
        val square = middle.toLong() * middle // Use `toLong` to prevent overflow
        println("Square of middle: $square")

        when {
            square == target.toLong() -> return true // Found a perfect square
            square < target -> left = middle + 1 // Search the right half
            else -> right = middle - 1 // Search the left half
        }
    }
    return false
}

//Lower bound problem
fun firstValue(intArray: IntArray, target: Int): Int {
    /**
     * Given an array of integers, find the first value where x >= target
     */
    var ans = -1
    var left = 0
    var right = intArray.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        when {
            intArray[mid] >= target -> {
                ans = intArray[mid]
                right = mid - 1
            }

            else -> left = mid + 1
        }
    }
    return ans
}