package dsa// Question

// Given an array of n items consisting of 0s, 1s, and 2s,
// write a solution that sorts the array in ascending order so that 0s are first, 1s are second and 2s are last.

// Input: [ 1, 0, 2, 1, 0, 0, 2, 1, 2, 0, 1, 2 ]
// Expected output: [ 0, 0 ,0, 0, 1, 1, 1, 1, 2, 2, 2, 2 ]


/**
 * Dutch national flag algorithm.
 * Space complexity -> O(1)
 * Time complexity -> O(n)
 * To solve this problem, you can use the Dutch National Flag algorithm, which efficiently sorts an array consisting of 0s, 1s, and 2s in linear time O(n) with a constant amount of extra space O(1).
 *
 * Here's how you can implement it in Kotlin:
 *
 * ### Dutch National Flag Algorithm in Kotlin
 *
 * ### Explanation:
 *
 * - **Three Pointers (`low`, `mid`, `high`)**:
 *   - `low` starts at the beginning of the array and is used to place all the `0`s in the correct position.
 *   - `mid` is used to traverse the array.
 *   - `high` starts at the end of the array and is used to place all the `2`s in the correct position.
 *
 * - **Algorithm Steps**:
 *   1. **If `arr[mid]` is `0`**:
 *      - Swap `arr[low]` and `arr[mid]`, then increment both `low` and `mid`.
 *   2. **If `arr[mid]` is `1`**:
 *      - Just move to the next element by incrementing `mid`.
 *   3. **If `arr[mid]` is `2`**:
 *      - Swap `arr[mid]` and `arr[high]`, then decrement `high` (but don't increment `mid`, because the swapped element needs to be checked).
 *
 * This algorithm ensures that the array is sorted in a single pass with minimal space usage, making it efficient and optimal for this problem.
 * */
fun sortArray(arr: Array<Int>) {
    var low = 0
    var mid = 0
    var high = arr.size - 1

    while (mid <= high) {
        when (arr[mid]) {
            0 -> {
                // Swap arr[low] and arr[mid], increment low and mid
                arr[low] = arr[mid].also { arr[mid] = arr[low] }
                low++
                mid++
            }
            1 -> {
                // Move to the next element
                mid++
            }
            2 -> {
                // Swap arr[mid] and arr[high], decrement high
                arr[high] = arr[mid].also { arr[mid] = arr[high] }
                high--
            }
        }
    }
}

fun main() {
    val array = arrayOf(1, 0, 2, 1, 0, 0, 2, 1, 2, 0, 1, 2)
    sortArray(array)
    println(array.joinToString(", ")) // Output: 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2
}
