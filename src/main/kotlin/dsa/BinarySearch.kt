package dsa

import kotlin.IllegalArgumentException

fun findMiddleElement(intArray: IntArray): Int {
    val right = intArray.indexOf(intArray.last())
    val left = intArray.indexOf(intArray.first())
    //use formula to get middle element => M = L + ((R - L )/2)...THIS FORMULA WILL RETURN THE POSITION OF THE MIDDLE ELEMENT
    val middle = intArray[left + ((right - left) / 2)]
    println("Middle: $middle")
    return middle
}

fun main() {
    //findMiddleElement()
    //println("Is it square: ${checkSquareRoot(square = 4, squareRoot = 2)}")
    val array = intArrayOf(1, 4, 57, 89, 45, 67, 34)
    println("Find my element: Index in array => [${binarySearch(array, 34)}]")
}

//returns the position of the element in the given array
fun binarySearch(intArray: IntArray, target: Int): Int {
    //the array has to be sorted
    intArray.sort()
    var left = 0
    var right = intArray.size - 1
    while (left <= right) {
        val middle = left + ((right - left) / 2)
        if (intArray[middle] == target) {
            return middle
        }
        if (intArray[middle] < target) {
            left = middle + 1
        } else {
            right = middle - 1
        }
    }
    throw IllegalArgumentException()
}

//partial implementation to check for square root...to be continued
fun checkSquareRoot(square: Int, squareRoot: Int): Boolean {
    val arrayRange = (0..square).map { it }.toIntArray()
    //return (findMiddleElement(arrayRange) * squareRoot) == square
    return true
}