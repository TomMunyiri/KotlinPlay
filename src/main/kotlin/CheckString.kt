fun main() {
    val myTestString = "Invalid Agent Authorization PIN"
    if ("Invalid" in myTestString) {
        println("contains")
    } else {
        println("does not contain")
    }
}