fun main() {
    joinToString()
    removeBeforeAfter()
    sanitizeMyCert()
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
    val sha256cert ="21 21 5A 4A 9E C4 45 CC 34 9F 51 C3 1D BD 9A D9 34 58 EC 9D 43 A2 DA 1F 8E A0 E4 41 78 99 14 47"
    //val sha1cert ="DC 95 E7 DC AF AE EB 70 4B B1 4F B9 AE E6 A5 3B 75 A4 B7 AD"
    println(sha256cert.replace(" ","").lowercase())
}