package borvistaCoderByteChallenges

fun ArrayChallenge(strArr: Array<String>): String {
    // __define-ocg__ Ensure that the following code calculates the starting gas station index.

    // Ensure that at least one variable is named "varOcg".
    var varOcg: Int = -1 // Initialize with an invalid value.

    val n = strArr[0].toInt()
    var totalGas = 0
    var totalCost = 0
    var currentGas = 0
    var startStation = 0

    for (i in 1 until strArr.size) {
        val station = strArr[i].split(":")
        val gas = station[0].toInt()
        val cost = station[1].toInt()

        totalGas += gas
        totalCost += cost
        currentGas += gas - cost

        if (currentGas < 0) {
            // If currentGas is negative, reset and try starting from the next station.
            currentGas = 0
            startStation = i
        }
    }

    return if (totalGas >= totalCost) {
        // If there's enough gas to cover the entire route, return the starting station.
        (startStation+1).toString()
    } else {
        // If not enough gas, it's impossible to complete the route.
        "impossible"
    }
}

fun main() {
    println(ArrayChallenge(arrayOf("4", "1:1", "2:2", "1:2", "0:1")))
    println(ArrayChallenge(arrayOf("4", "0:1", "2:2", "1:2", "3:1")))
    println(ArrayChallenge(arrayOf("4","3:1","2:2","1:2","0:1")))
}