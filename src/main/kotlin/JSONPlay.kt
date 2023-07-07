import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

fun main() {
    val jsonString =
        "[{\"MIN\":5,\"MAX\":\"7000000\",\"F100\":\"FLOAT_PULL\",\"F3\":\"400000\"},{\"MIN\":5,\"MAX\":\"7000000\",\"F100\":\"FLOAT_PUSH\",\"F3\":\"400000\"}]"
    println("MAX: " + getTransactionMax(jsonString, "FLOAT_PULL"))
    println("MIN: " + getTransactionMin(jsonString, "FLOAT_PULL"))
}

fun getTransactionMax(jsonString: String, transactionType: String): String {
    val jsonArray = JSONArray(jsonString)
    val jsonList = (0 until jsonArray.length()).map { jsonArray.getJSONObject(it) }
    val jsonObjectList = jsonList.filter { it.optString("F100") == transactionType }
    return if (jsonObjectList.isNotEmpty()) jsonObjectList[0].optString("MAX") else "(Not Set)"
}

fun getTransactionMin(jsonString: String, transactionType: String): Int {
    val jsonArray = JSONArray(jsonString)
    val jsonList = (0 until jsonArray.length()).map { jsonArray.getJSONObject(it) }
    val jsonObjectList = jsonList.filter { it.optString("F100") == transactionType }
    return if (jsonObjectList.isNotEmpty()) jsonObjectList[0].optInt("MIN") else 0
}