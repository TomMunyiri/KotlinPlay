fun main(){
    val array= listOf(1,3,4,6,6,3,3,10,10,2,0,0)
    // toSet() - remove duplicates
    // sorted() - sorts array in ascending order
    // sortedByDescending() - sorts array in descending order
    println(array.toSet().sorted())
}