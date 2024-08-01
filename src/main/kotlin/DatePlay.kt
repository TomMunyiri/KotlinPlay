import kotlinx.datetime.*

fun main() {
    println(monthDays(2024, Month.SEPTEMBER))
}

fun monthDays(year: Int, month: Month): String {
    val start = LocalDate(year, month, 1)
    val end = start.plus(DateTimeUnit.MONTH)
    return start.until(end, DateTimeUnit.DAY).toString()
}
