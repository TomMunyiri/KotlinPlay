package borvistaCoderByteChallenges

/*Array Challenge

Have the function ArrayChallenge(strArr) take strArr which will be an an array consisting of the following elements:
N which will be the number of gas stations in a circular route and each subsequent element will be the string g:c
where g is the amount of gas in gallons at that gas station and c will be the amount of gallons of gas needed
to get to the following gas station.

For example strArr may be: ["4","3:1","2:2","1:2","0:1"].
Your goal is to return the index of the starting gas station that will allow you to travel around the whole route once,
otherwise return the string impossible. For the example above, there are 4 gas stations,
and your program should return the string 1 because starting at station 1 you receive 3 gallons of gas and spend 1 getting to the next station.
Then you have 2 gallons + 2 more at the next station and you spend 2 so you have 2 gallons when you get to the 3rd station.
You then have 3 but you spend 2 getting to the final station, and at the final station you receive 0 gallons and you spend your
final gallon getting to your starting point. Starting at any other gas station would make getting around the route impossible, so the answer is 1.
If there are multiple gas stations that are possible to start at, return the smallest index (of the gas station). N will be >= 2.
Examples
Input: arrayOf("4","1:1","2:2","1:2","0:1")
Output: impossible
Input: arrayOf("4","0:1","2:2","1:2","3:1")
Output: 4*/

fun ArrayChallenge(strArr: Array<String>): String {

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
        (startStation + 1).toString()
    } else {
        // If not enough gas, it's impossible to complete the route.
        "impossible"
    }
}

fun main() {
    println(ArrayChallenge(arrayOf("4", "1:1", "2:2", "1:2", "0:1")))
    println(ArrayChallenge(arrayOf("4", "0:1", "2:2", "1:2", "3:1")))
    println(ArrayChallenge(arrayOf("4", "3:1", "2:2", "1:2", "0:1")))
}