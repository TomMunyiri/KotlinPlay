fun main() {
    val bundleList = arrayListOf<MyBundle>()
    bundleList.add(MyBundle("UGX 13,000", "14"))
    bundleList.add(MyBundle("UGX 10,000", "12"))
    //val gson = Gson
    //val list=Gson().fromJson(json, Array<SomeObject>::class.java).asList()
    println("bundle ${bundleList.toString()}")
    println("test: ".toString())
}

fun String.`toString`(): String {
    return "this is me"
}

data class MyBundle(
    val price: String,
    val trip: String
)