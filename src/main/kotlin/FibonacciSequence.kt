fun main() {
    fibonacci(8)
    //val number="147827.0795"
    //println(number.formatAmount())
}

fun fibonacci(limit: Int) {
    var prev = 0
    var current = 1
    var prevprev = 0
    //1,1,2,3,5,8,13,21
    for (i in 1..limit) {
        println(current)
        //help us hold current value after each iteration before it is incremented
        val temp = current
        prevprev = prev
        prev = temp
        current = prev + prevprev
    }
}



