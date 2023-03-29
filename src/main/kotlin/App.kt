import java.io.PrintWriter
import java.io.StringWriter
import java.util.regex.Pattern
import org.json.JSONArray;
import org.json.JSONObject;

fun main() {
    //kotlinTernaryOperator()
    //conditionalIfElse()
    //kotlinWhile()
    val testBody = TestBody("tom", "mwangi", true)
    val array = arrayOf("tom", "mwangi", "hello", "run")
    var x = 0
    while (x < 4) {
        println("${array[x]} is a good name")
        x += 1
    }
    val mini =
        "2023-03-28 15:30 PM|DR|5|Send Money to Tom Mwangi Munyiri - 75***91[Receive Money from Gimson Waibala - 75***91|100000100054|FT~2023-03-28 15:26 PM|CR|5|100000049721 P2P Waibala  Waibala - 72***83|100000100053|FT~2023-03-28 15:23 PM|DR|5|100000049697 P2P Customer - 75***91|100000100052|FT~"
    println(formatMinistatement(mini))
}

fun formatMinistatement(mini: String): String? {
    val miniArray = JSONArray()
    val miniStrings: Array<String> =
        mini.split(Pattern.quote("~").toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    for (miniString in miniStrings) {
        val miniStatement = JSONObject()
        val miniItems: Array<String> =
            miniString.split(Pattern.quote("|").toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        miniItems.forEach {
            println(it)
        }
        miniStatement.put("date", miniItems[0])
        miniStatement.put("naration", miniItems[3])
        miniStatement.put("type", miniItems[1])
        miniStatement.put("amount", miniItems[2])
        miniStatement.put("transRef", miniItems[4])
        val transactionType = miniItems[5]
        if ("FT".equals(transactionType, ignoreCase = true)) {
            val drCr = miniItems[1]
            val narration = miniItems[3]
            val narrationStrings: Array<String> =
                narration.split(Pattern.quote("[").toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            try {
                if ("CR".equals(drCr, ignoreCase = true)) {
                    miniStatement.put("naration", narrationStrings[1])
                } else if ("DR".equals(drCr, ignoreCase = true)) {
                    miniStatement.put("naration", narrationStrings[0])
                }
            } catch (e: Exception) {
                miniStatement.put("naration", miniItems[3])
            }
        }
        miniArray.put(miniStatement)
    }
    return miniArray.toString()
}

fun maskPhone(phoneNumber: String): String? {
    val maskedPhoneNumber: String = try {
        //String cardEnc = unDecMe(Base64.decodeBase64(encodedCard));
        phoneNumber.substring(0, 2) + "***" + phoneNumber.substring(5, 7)
    } catch (e: Exception) {
        val sw = StringWriter()
        e.printStackTrace(PrintWriter(sw))
        "Error in Card display"
    }
    return maskedPhoneNumber
}

class TestBody(val firstName: String, val lastName: String, val isEmployed: Boolean) {
    var t: String = "4"
    var r = t.toInt()
    val z = r.toString()
}

fun kotlinWhile() {
    var x = 0
    var y = 0
    while (x < 5) {
        //y=x-y
        y += x
        print("$x$y ")
        x += 1
    }/*var x=1
    while(x<10){
        if(x>3){
            println("big x")
        }
    }*//*var x=10
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