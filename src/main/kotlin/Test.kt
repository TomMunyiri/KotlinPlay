import java.text.DecimalFormat
import kotlin.math.roundToInt

fun main() {
    val s = "35437.582954".roundOffDecimals()
    println("Result: $s")
}

fun String.roundOffDecimals(): String {
    return DecimalFormat("##.##").format(this.toDouble()).toString()
}