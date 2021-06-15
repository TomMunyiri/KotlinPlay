fun main() {
    val options = arrayOf("Rock", "Paper", "Scissors")
    print("Your choice: ${getUserChoice(options)}\n")
    print("Machine's choice: ${getGameChoice(options)}")
}

/*fun doSomething(msg: String, i: Int): Unit {
    if (i > 0) {
        var x = 0
        while (x < i) {
            println(msg)
            x += 1
        }
    }
}

fun timesThree(x: Int): Int {
    val y = x * 3
    return x
}

fun maxValue(args: Array<Int>):Int {
    var max = args[0]
    var x = 1
    while (x < args.size) {
        var item = args[x]
        max = if (max >= item) max else item
        x = x + 1
    }
    return max
}*/


fun getUserChoice(options: Array<String>): String {
    print("Choose an option below: \n")
    var x = 0
    while (x < options.size) {
        print("${x + 1}. ${options[x]}\n")
        x += 1
    }

    val userInputChoice = readLine().toString()
    return when (userInputChoice.toInt()) {
        1 -> options[0]
        2 -> options[1]
        3 -> options[2]
        else -> "Please enter a valid input choice"
    }
}

fun getGameChoice(options: Array<String>): String {
    return options[(Math.random() * options.size).toInt()]
}