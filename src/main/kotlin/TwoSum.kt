import kotlin.properties.Delegates

fun twoSum(nums: IntArray, target: Int): IntArray {
    //uses hashmap. not suitable for larger data sets
    //[2,7,11,15]
    val map = HashMap<Int, Int>()
    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }
        map[nums[i]] = i
    }
    throw IllegalArgumentException("No two sum solution")
}

fun twoSum2(nums: IntArray, target: Int): IntArray {
    //pointers - suitable for larger data sets
    nums.sort() // Sort the array in ascending order
    var left = 0
    var right = nums.lastIndex
    while (left < right) {
        val currentSum = nums[left] + nums[right]
        if (currentSum == target) {
            return intArrayOf(left, right)
        } else if (currentSum < target) {
            left++
        } else {
            right--
        }
    }
    throw IllegalArgumentException("No two sum solution")
}

fun main() {
    val myArray = intArrayOf(2, 7, 11, 15)
    val result = twoSum(myArray, 9)
    val result2 = twoSum2(myArray, 9)

    println("The numbers are ${myArray[result2[0]]} and ${myArray[result2[1]]}")
    println("Indices of the two numbers: ${result[0]}, ${result[1]}")
    println("Indices of the two numbers: ${result2[0]}, ${result2[1]}")
}