import kotlin.system.measureNanoTime

/**
 * Let's compare a normal for loop and for each in terms of performance
 * https://medium.com/mobile-app-development-publication/kotlin-for-loop-vs-foreach-7eb594960333
 */
fun main() {
    println("INT RANGES")
    compareForLoopsIntRanges()
    println("LISTS")
    compareForLoopsLists()
    println("SEQUENCE")
    compareForLoopsSequence()
}

/**INT RANGES
 * When it is normal IntRange, using forEach uses 10x more time than For-loop
 * For Loop is faster in this case
 */
fun compareForLoopsIntRanges() {
    println("For Loop Time: " + measureNanoTime {
        for (i in 1..1000) {
            i.doStuff()
        }
    })
    println("For Each Time: " + measureNanoTime {
        (0..1000).forEach { i ->
            i.doStuff()
        }
    })
}

/** Looping through a list
 * For Each is faster in this case
 */
fun compareForLoopsLists() {
    val list = (1..1000).toList()
    println("For Loop Time: " + measureNanoTime {
        for (i in list) {
            i.doStuff()
        }
    })
    println("For Each Time: " + measureNanoTime {
        list.forEach { i ->
            i.doStuff()
        }
    })
}

/** Looping through a sequence
 * For Each is faster in this case
 */
fun compareForLoopsSequence() {
    val sequence = (1..1000).asSequence()
    println("For Loop Time: " + measureNanoTime {
        for (i in sequence) {
            i.doStuff()
        }
    })
    println("For Each Time: " + measureNanoTime {
        sequence.forEach { i ->
            i.doStuff()
        }
    })
}

fun Int.doStuff(): String {
    return "Stuff $this"
}

/**Sample results
 * INT RANGES
For Loop Time: 3569700
For Each Time: 4213900
LISTS
For Loop Time: 555300
For Each Time: 509200
SEQUENCE
For Loop Time: 460500
For Each Time: 433000
 */