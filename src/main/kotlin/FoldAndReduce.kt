fun main() {
    reduceExample()
    foldExample()
}

/**
 * Fold and Reduce functions are used to accumulate value into a single result
 * Fold takes 2 parameters - `seed` value and a high order function
 * Reduce takes only a high order function
 */

fun reduceExample() {
    //lets find the sum of 1 to 5 elements
    (1..5).reduce { acc, value ->
        acc + value
    }.also {
        println(it)
    }
    //acc is the accumulated value and value is the latest value from the list
}

fun foldExample() {
    //lets find the sum of 1 to 5 elements. O(seed value) is the initial value of acc. You can change it and see the effect
    (1..5).fold(0) { acc, value ->
        acc + value
    }.also {
        println(it)
    }
}