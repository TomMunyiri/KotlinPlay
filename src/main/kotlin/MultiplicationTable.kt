fun main() {
    multiplicationBoard(10)
}

fun multiplicationBoard(size : Int){
    for(number in 1..size){
        print(" | ")
        for(otherNumber in 1..size){
            print("$number x $otherNumber = ${number * otherNumber} | ")
        }
        println()
    }
}