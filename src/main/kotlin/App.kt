fun main() {
    //kotlinTernaryOperator()
    //conditionalIfElse()
    //kotlinWhile()
    val testBody = TestBody("tom", "mwangi", true)
    val array = arrayOf("tom","mwangi","hello","run")
    var x=0
    while (x<4){
        println("${array[x]} is a good name")
        x += 1
    }
}

class TestBody(val firstName: String, val lastName: String, val isEmployed: Boolean) {
    var t:String = "4"
    var r =t.toInt()
    val z=r.toString()
}

fun kotlinWhile() {
    var x = 0
    var y = 0
    while (x < 5) {
        //y=x-y
        y += x
        print("$x$y ")
        x += 1
    }
    /*var x=1
    while(x<10){
        if(x>3){
            println("big x")
        }
    }*/
    /*var x=10
    while(x>1){
        x -= 1
        *//*if(x<3){
            println("small x")
        }*//*
        println(if(x<3) "small x" else "big x")
    }*/
}

fun conditionalIfElse() {
    val x = 2
    val y = 3
    print(if (x > y) "x is greater than y" else "x is not greater than y")
}

fun kotlinTernaryOperator() {
    val a = 1
    val b = 2
    val c = 3
    val d = if (a > 0) b else c
    print("$d")
}