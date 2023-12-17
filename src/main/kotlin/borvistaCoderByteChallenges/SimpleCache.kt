package borvistaCoderByteChallenges

fun main() {
    val cache = SimpleCache()

    // Modifying the cache (keep this here)
    println(cache.add("article-123", "https://coderbyte.com/article-123"))
    println(cache.add("article-456", "https://coderbyte.com/article-456"))
    println(cache.add("how-to-code-444", "https://coderbyte.com/how-to-code-444"))
    println(cache.get("first-article"))
    println(cache.get("second-article"))
    println(cache.get("article-456"))
    println(cache.add("article-123", "https://coderbyte.com/article-123"))
    println(cache.size())
}

class SimpleCache {
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
