fun main() {
    val h1 = Header("H1")
    val h2 = Header("H2")
    //combine using an extension function
    //val h3 = h1.plus(h2)
    //combine using an infix function
    val h3 = h1 plus h2
    println(h3)
}

data class Header(val name: String)

//combine 2 headers using an extension function
/*fun Header.plus(otherHeader: Header): Header {
    return Header(this.name + otherHeader.name)
}*/

//combine 2 headers using an infix function
infix fun Header.plus(otherHeader: Header): Header {
    return Header(this.name + otherHeader.name)
}