
import java.text.DecimalFormat


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
