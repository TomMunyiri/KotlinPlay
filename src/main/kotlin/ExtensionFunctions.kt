
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*


/**
 * Round off to 2dp
 * and add comma separator.
 * @return string string
 */
fun String.formatAmount():String {
    val number = this.toDouble()

    //NumberFormat.getInstance().format(myNumber);
    val formatter = DecimalFormat("#,##0.00") //pattern ==> "#,##0"
    //NumberFormat formatter =NumberFormat.getInstance();
    return formatter.format(number)
}

fun String.formatToReadableDateFormat(): String {
    // Define the input and output date formats
    val inputFormat = SimpleDateFormat("MM/dd/yyyy", Locale.US)
    val outputFormat = SimpleDateFormat("MMM d, yyyy", Locale.US)

    // Parse the input date string
    val date = inputFormat.parse(this)

    // Return the formatted date string
    return date?.let { outputFormat.format(it) } ?: "Invalid date"
}
