import java.text.DecimalFormat

fun main() {
    /*val s = "35437.582954".roundOffDecimals()
    println("Result: $s")*/

    for (num in 0..10) {
        println("$num is even = ${checkEvenNumber(num)}")
    }
}

fun String.roundOffDecimals(): String {
    return DecimalFormat("##.##").format(this.toDouble()).toString()
}

fun checkEvenNumber(num: Int): Boolean {
    return num % 2 == 0
}