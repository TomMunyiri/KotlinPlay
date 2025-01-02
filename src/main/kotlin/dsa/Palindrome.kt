package dsa

fun <T> isPalindrome(input: T): Boolean {
    return input.toString() == input.toString().reversed()
}

fun main() {
    println("Is number a palindrome? ${isPalindrome("radar")}")
}