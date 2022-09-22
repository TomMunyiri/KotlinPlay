fun main() {
    fibonacci(8)
}

fun fibonacci(limit: Int) {
    var prev = 0
    var current = 1
    var prevprev = 0
    //1,1,2,3,5,8,13,21
    for (i in 1..limit) {
        println(current)
        val temp = current
        prevprev = prev
        prev = temp
        current = prev + prevprev
    }
}