import kotlinx.datetime.*

fun main() {
    println(`get number of days in month`(2024, Month.SEPTEMBER))
}

fun `get number of days in month`(year: Int, month: Month): String {
    val start = LocalDate(year, month, 1)
    val end = start.plus(DateTimeUnit.MONTH)
    return start.until(end, DateTimeUnit.DAY).toString()
}

