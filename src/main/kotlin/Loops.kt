import java.util.TreeMap

fun main() {
    //for loop with range. this will include even 10 in the loop
    for (x in 1..10) println(x)

    //this will exclude 10
    for (x in 1 until 10) println(x)

    for (x in 1..10 step 2) println(x)

    for (x in 10 downTo 1) println(x)

    val ages = TreeMap<String, Int>()
    ages["Tom"] = 25
    ages["Liz"] = 24
    ages["Eunice"] = 55
    ages["Edwin"] = 30
    ages["Rocky"] = 89
    for ((name, age) in ages) {
        println("Name: $name. Age: $age")
    }
}