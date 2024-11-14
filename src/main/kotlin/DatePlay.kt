import kotlinx.datetime.*

fun main() {
    println(`get number of days in month`(2024, Month.FEBRUARY))
    println(`get number of days in year`(2023))
    val map = mutableMapOf<String,String>()
    map.computeIfAbsent("ddssdd"){
        "test"
    }
}

fun `get number of days in month`(year: Int, month: Month): String {
    val start = LocalDate(year, month, 1)
    val end = start.plus(DateTimeUnit.MONTH)
    return start.until(end, DateTimeUnit.DAY).toString()
}

fun `get number of days in year`(year: Int): Int {
    val start = LocalDate(year, 1, 1)
    val end = LocalDate(year + 1, 1, 1)
    return start.daysUntil(end)
}


