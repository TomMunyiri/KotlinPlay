import kotlinx.coroutines.*

fun main() {
    println("${Thread.currentThread().name} -> thread has run.")
    val thread = Thread {
        println(Thread.currentThread().name)
    }
    thread.start()

    runBlocking {
        launch {
            delay(1000L)
            println("World")
        }
        println("Hello")
    }
}