fun main(){
    val myTestString="Invalid Agent Authorization PIN"
    if(myTestString in "Invalid"){
        println("contains")
    }else{
        println("does not contain")
    }
}