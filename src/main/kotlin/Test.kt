import java.text.DecimalFormat

fun main() {
    val s = "35437.582954".roundOffDecimals()
    println("Result: $s")
}

fun String.roundOffDecimals(): String {
    return DecimalFormat("##.##").format(this.toDouble()).toString()
}