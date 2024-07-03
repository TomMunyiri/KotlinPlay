package equityGroupCodility



private fun validateEmail(): Boolean {
    // Check if the email matches the standard pattern
    val email = "test@test.com"
    val emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$".toRegex()
    //return email.matches(emailRegex)
    return email.matches(emailRegex)
}

fun main() {
    if (validateEmail()){
        println("valid")
    }else{
        println("invalid")
    }

}