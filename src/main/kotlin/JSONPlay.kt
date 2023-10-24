import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

fun main() {
    val jsonString =
        "[{\"MIN\":5,\"MAX\":\"7000000\",\"F100\":\"FLOAT_PULL\",\"F3\":\"400000\"},{\"MIN\":5,\"MAX\":\"7000000\",\"F100\":\"FLOAT_PUSH\",\"F3\":\"400000\"}]"
    println("MAX: " + getTransactionMax(jsonString, "FLOAT_PULL"))
    println("MIN: " + getTransactionMin(jsonString, "FLOAT_PULL"))
    //val originalJson = "[{\"VOUCHER\":\"89948348011720783098,55815542305821919565,41555448439880737492,67477389715277317882\",\"PHONE_NO\":6777557691}]"
    val originalJson = "[]"
    val newVoucher = "1234567890"

    val updatedJson = addVoucherToJSON(originalJson, newVoucher)
    println(createJsonString("89948348011720783098", "6777557691"))
    //println(updatedJson)
}

fun createJsonString(voucher: String, phoneNo: String): String {
    val jsonObject = JSONObject()
    jsonObject.put("VOUCHER", voucher)
    jsonObject.put("PHONE_NO", phoneNo)

    val jsonArray = JSONArray()
    jsonArray.put(jsonObject)

    return jsonArray.toString()
}

fun addVoucherToJSON(originalJson: String, newVoucher: String): String {
    try {
        // Parse the original JSON string to a JSON array
        val jsonArray = JSONArray(originalJson)

        // Make sure the JSON structure is as expected
        if (jsonArray.length() == 1) {
            val jsonObject = jsonArray.getJSONObject(0)

            // Get the "VOUCHER" field as a string
            val voucherField = jsonObject.optString("VOUCHER")

            // Split the "VOUCHER" field into individual voucher items
            val voucherItems = voucherField.split(",").toMutableList()

            // Add the new voucher item to the beginning of the list
            voucherItems.add(0, newVoucher)

            // Join the voucher items back into a string
            val updatedVoucherField = voucherItems.joinToString(",")

            // Update the JSON object with the modified "VOUCHER" field
            jsonObject.put("VOUCHER", updatedVoucherField)

            // Convert the JSON array back to a JSON string
            return jsonArray.toString()
        } else {
            return createJsonString("89948348011720783098", "6777557691")
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }

    // If there was an issue with the input JSON, return the original JSON
    return originalJson
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