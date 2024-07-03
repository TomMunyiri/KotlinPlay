import com.google.gson.Gson

/**
 * This is the perfect example I found on Twitter for high order functions implementation
 * Thanks to Mambo Bryan
 */
fun main() {
    print("Enter Degrees Celsius to be converted: ")
    val degrees: Double = readLine()?.toDouble() ?: 0.0
    val fahrenheit = convertDegreesToFahrenheit(degrees, { it * 1.8 + 32 })
    println("$degrees Degrees Celsius =  $fahrenheit Fahrenheit")
    val gson = Gson()
    val myJson = gson.toJson("{\"data\":{\"array:\"[]}}")
    println(myJson)

    runCalculator()
}

/**
 * Converting Degrees to Fahrenheit
 * This function takes in 2 parameters which are temperature (Double) and convert (Function) . It then returns a Double
 * @convert is a function which takes in one parameter which is number (Double) . It then returns a Double
 */
fun convertDegreesToFahrenheit(temperature: Double, convert: (number: Double) -> Double): Double {
    return convert(temperature)
}

// Higher order function example: Calculator
fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

fun add(x: Int, y: Int): Int {
    return x + y
}

fun subtract(x: Int, y: Int): Int {
    return x - y
}

fun multiply(x: Int, y: Int): Int {
    return x * y
}

fun runCalculator() {
    val result1 = calculate(10, 5, ::add)
    println("Addition: $result1") // Output: Addition: 15
    val result2 = calculate(10, 5, ::subtract)
    println("Subtraction: $result2") // Output: Subtraction: 5
    val result3 = calculate(10, 5, ::multiply)
    println("Multiplication: $result3") // Output: Multiplication: 50
}