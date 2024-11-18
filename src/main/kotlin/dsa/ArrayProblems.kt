package dsa

/** Given an unsorted array and a target value, find how many times the target value
 * appears in the array
 */

fun main() {
    val intArray = intArrayOf(1, 3, 3, 56, 56, 7, 67, 8, 3, 89, 46, 56)
    val target = 67
    println("How many times does $target appear in the array? ${findTimesOfAppearanceInt(intArray, target)}")

    val stringArray = arrayOf("Tom", "Tom", "Mbote", "Njogu", "Njogu")
    val targetString = "Njogu"
    println(
        "How many times does $targetString appear in the array? ${
            findTimesOfAppearanceString(stringArray, targetString)
        }"
    )
}

fun findTimesOfAppearanceInt(intArray: IntArray, target: Int): Int {
    /**
     * Time complexity: O(n)...linear time
     * Space complexity: O(1)...constant space
     */
    var count = 0
    for (i in intArray) {
        if (i == target) {
            count++
        }
    }
    return count
}

fun findTimesOfAppearanceString(stringArray: Array<String>, target: String): Int {
    var count = 0
    for (i in stringArray) {
        if (i == target) {
            count++
        }
    }
    return count
}