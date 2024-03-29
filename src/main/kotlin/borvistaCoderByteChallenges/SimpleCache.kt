package borvistaCoderByteChallenges

/*Back-end Challenge
You are building a small part of this Android application that needs to implement a simple key-value type of cache.
In Kotlin, you will need to implement a cache object with the functions add, get, and size.

The add function takes two parameters, a key and value and adds the pair to the local cache.
When an item is added to the cache, this function should return the string "added" and if the item already existed in the cache,
this function should return the string "overwritten"

The get function attempts to retrieve an item from the cache based on the key parameter passed in.
If the item exists in the cache, return the value, otherwise return the string "miss"

The size function simply returns the number of items in the cache.

Your goal is to implement the cache object so the function calls in the main method work properly.
The output of your program should be a final string with the function outputs separated by a space.

The Android device on the right side takes in your output and presents it on screen in a formatted way so you can easily visualize it.

Example Input
cache.add("a", "value1")
cache.add("b", "value2")
cache.add("b", "value2")
cache.add("rrrrr", "nothing")
cache.get("hello")
cache.get("world")
cache.get("b")
cache.get("rrrrr")
cache.size()

Example Output
added added overwritten added miss miss value2 nothing 3*/

fun main() {
    val cache = SimpleCache

    // Modifying the cache (keep this here)
    print(cache.add("article-123", "https://coderbyte.com/article-123"))
    print(" ")
    print(cache.add("article-456", "https://coderbyte.com/article-456"))
    print(" ")
    print(cache.add("how-to-code-444", "https://coderbyte.com/how-to-code-444"))
    print(" ")
    print(cache.get("first-article"))
    print(" ")
    print(cache.get("second-article"))
    print(" ")
    print(cache.get("article-456"))
    print(" ")
    print(cache.add("article-123", "https://coderbyte.com/article-123"))
    print(" ")
    print(cache.size())
    print(" ")

    print(cache.add("a", "value1"))
    print(" ")
    print(cache.add("b", "value2"))
    print(" ")
    print(cache.add("b", "value2"))
    print(" ")
    print(cache.add("rrrrr", "nothing"))
    print(" ")
    print(cache.get("hello"))
    print(" ")
    print(cache.get("world"))
    print(" ")
    print(cache.get("b"))
    print(" ")
    print(cache.get("rrrrr"))
    print(" ")
    print(cache.size())
    print(" ")
}

object SimpleCache {
    private val cacheMap = mutableMapOf<String, String>()

    fun add(key: String, value: String): String {
        return if (cacheMap.containsKey(key)) {
            cacheMap[key] = value
            "overwritten"
        } else {
            cacheMap[key] = value
            "added"
        }
    }

    fun get(key: String): String {
        return cacheMap[key] ?: "miss"
    }

    fun size(): Int {
        return cacheMap.size
    }
}
