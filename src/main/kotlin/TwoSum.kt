import kotlin.properties.Delegates

fun twoSum(nums: IntArray, target: Int): Boolean {
    //[2,7,11,15]
    val low = 0
    val hi = nums.size - 1
    var isThere by Delegates.notNull<Boolean>()
    val array: IntArray = intArrayOf()
    while (low < hi) {
        if ((nums[hi] + nums[low]) == target) {
            nums.indices
            val one = low
            val two = hi
            isThere = true
            break
        }
    }
    return isThere
}

fun main() {
    val myArray = intArrayOf(2, 7, 11, 15)
    println("Present: ${twoSum(myArray, 9)}")
}