import com.google.gson.JsonParser


fun main() {
    joinToString()
    removeBeforeAfter()
    sanitizeMyCert()
    nonsense()
}

private fun joinToString() {
    data class Fruit(val name: String, val sugar: Int)

    val fruits = listOf(
        Fruit("mango", 12),
        Fruit("orange", 34),
        Fruit("passion", 45),
        Fruit("lemon", 78),
        Fruit("apple", 2),
        Fruit("peach", 16),
        Fruit("water melon", 17),
    ).sortedBy(Fruit::sugar)

    val joinFruits = fruits.reversed().joinToString(
        separator = ",", prefix = "\uD83D\uDE18 = [", postfix = "]", limit = 3, truncated = "MORE", transform = Fruit::name
    )

    println(joinFruits)
}

private fun removeBeforeAfter() {
    val myString = "404404003001"
    var newString = ""
    newString = myString.substring(3, myString.length - 3)
    println(newString)
}

private fun sanitizeMyCert(){
    val sha256cert ="55 B7 A2 99 A2 5D 26 4E 03 13 5F D5 C0 EF BF B9 09 51 7F 8A F6 FD 37 83 C5 B2 9B 0D 67 63 AD 4C"
    //val sha1cert ="DC 95 E7 DC AF AE EB 70 4B B1 4F B9 AE E6 A5 3B 75 A4 B7 AD"
    println(sha256cert.replace(" ","").uppercase())
}

private fun nonsense(){
    // Parse the input into a JsonObject
    // Parse the input into a JsonObject
    val inputData = "{MeterNumber: 07048787894,InitialAmount: 150.56,ConsumerAccount:C70550000,MinimumVendAmount: 5.71,Owing: 150.56,ConsumerFirstName:BEN,ConsumerSurname:HARRY\n" +
            "    }"
    val jsonObject = JsonParser.parseString(inputData).asJsonObject

    // Print the JsonObject

    // Print the JsonObject
    println(jsonObject)
}