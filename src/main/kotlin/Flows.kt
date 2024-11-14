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

/**
 * Flow - think of it as a river carrying data from various sources to different parts of your app
 *      - Is a cold stream.
 *      - Does not represent state.
 *      - Does not remember past values. Each time you collect from a Flow, it starts from scratch
 *      - It is immutable once created
 *      - Best for asynchronous data streams where past values are not crucial
 *      * Usages: fetching data from internet, reading sensor data, handling user interactions, database queries
 */
/**
 * StateFlow - think of it as a special river with a memory. It remembers the latest piece of information that flowed through it
 *           - Is a hot stream
 *           - represents a single state
 *           - remembers and exposes the latest value emitted
 *           - Conflates values - if a new value is set before the previous one is collected, the previous value is overwritten
 *           - Emits values only when they differ from the previous item
 *           - MutableStateFlow(value) - requires an initial value
 *           - Usages: UIState->screen visibility, text content, user input
 */
/**
 * SharedFlow - think of it as a river that branches out, sharing the same water (data) with multiple destinations
 *            - share data with multiple subscribers simultaneously
 *            - Is a hot stream
 *            - MutableSharedFlow() - does not require an initial value
 *            - Unlike StateFlow, it emits all values regardless of whether they differ from previous item
 *            - Can optionally have a replay cache - it can replay a specified number of previously emitted values to new subscribers
 *            - Provides configurable conflation options to handle different overflow strategies
 *            - tryEmit() - emit values and not suspend the caller, it returns a boolean immediately if the buffer is full, enabling error handling
 *            - Usages: Broadcasting events or updates - new messages in chat app, theme changes, synchronize shopping cart changes
 */