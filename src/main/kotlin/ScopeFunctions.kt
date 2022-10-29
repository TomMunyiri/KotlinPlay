/**
 * Referenced this article by Banda https://effbada.hashnode.dev/understanding-kotlin-scope-functions-ckcfxb0c000093cs10gsdcvhe
 */
data class Animal(
    var name: String = "Panda",
    var colour: String = "Black",
    var origin: String? = "Greenland",
)

fun main() {
    letExample()
}

fun letExample() {
    /**
     * By default, the last statement in a let block is a return statement if it is not an assignment
     */
    val animal = Animal().let {
        //this is a string so it will return a string
        "This animal is from ${it.origin}"
    }
    println(animal)
    val animal1 = Animal().let {
        //this is an assignment so it will return kotlin.Unit
        //we are assigning the origin to a new value and are not returning anything
        it.origin = "Kenya"
        //if we did this, a string will be returned with the origin having been updated to the new value
        //"This animal is from ${it.origin}"
    }
    //let can help us ensure null safety thus saving us from the lengthy null checks
    val animal2 = Animal().origin?.let {

    }
    println(animal1)
}

fun applyExample() {

}

fun withExample() {

}

fun alsoExample() {

}

fun runExample() {

}