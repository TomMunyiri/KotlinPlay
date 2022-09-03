//Sealed classes restrict the Type hierarchy. In the case below, the PersonEvent can only have 3 types
sealed class PersonEvent {
    //nested sub-classes
    object Awake : PersonEvent()
    object Asleep : PersonEvent()
    class Eating(val food: String) : PersonEvent()
}

fun handlePersonEvent(event: PersonEvent) {
    when (event) {
        is PersonEvent.Awake -> println("Awake")
        is PersonEvent.Asleep -> println("Asleep")
        is PersonEvent.Eating -> println(event.food)
    }
}

fun main() {
    handlePersonEvent(PersonEvent.Eating("Apple"))
    handlePersonEvent(PersonEvent.Awake)
    handlePersonEvent(PersonEvent.Asleep)
}
