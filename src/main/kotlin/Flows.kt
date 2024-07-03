import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 * Hot Flow - Emits values irrespective of listener's/consumer's/observer's presence. e.g StateFlow, SharedFlow
 * Usages: Radio signals, GPS signals, Stock market charts, Live video calls
 * Cold Flow - Emits values only in listener's/consumer's/observer's presence. It can only have one subscriber. e.g flow
 * Advantages:
 * 1. No resource wasted unlike in hot streams. Only emits when listener/consumer is present
 * 2. No need to close the stream manually unlike in hot stream. It will not produce values if there is no consumer
 */

fun main() {
    //Flow (Cold stream)
    runBlocking {
        //collect acts as a terminal operator. Our flow is not active until collect is called
        countDownTimer().collect { value -> println("Current Value: $value") }
    }
}

fun countDownTimer(): Flow<Int> {
    val startingValue = 10
    //this id a cold flow. flows by default are cold
    return flow {
        var currentValue = startingValue
        emit(startingValue)
        while (currentValue > 0) {
            delay(1000L)
            currentValue--
            emit(currentValue)
            //println("Current Value: $currentValue")
        }
    }
}