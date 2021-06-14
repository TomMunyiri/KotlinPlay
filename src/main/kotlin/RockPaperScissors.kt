fun main() {
    val options = arrayOf("Rock", "Paper", "Scissors")
    print("Your choice: ${getUserChoice(options)}\n")
    print("Machine's choice: ${getGameChoice(options)}")
}

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