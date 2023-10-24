package codilityTasks/*
This is a demo task.

Write a function:

fun solution(A: IntArray): Int

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].*/

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

fun solution(A: IntArray): Int {
    // Implement your solution here
    val set = HashSet<Int>()
    for(element in A){
        if(element>0){
            set.add(element)
        }
    }
    var smallestMissing = 1
    while(set.contains(smallestMissing)){
        smallestMissing++
    }
    return smallestMissing
}

//use the above function
fun main(){
    val A = intArrayOf(1,3,6,4,1,2)
    val result = solution(A)
    println("Result: $result")
}
