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
    val myJson=gson.toJson("{\"data\":{\"array:\"[]}}")
    println(myJson)
}

/**
 * Converting Degrees to Fahrenheit
 * This function takes in 2 parameters which are temperature (Double) and convert (Function) . It then returns a Double
 * @convert is a function which takes in one parameter which is number (Double) . It then returns a Double
 */
fun convertDegreesToFahrenheit(temperature: Double, convert: (number: Double) -> Double): Double {
    return convert(temperature)
}