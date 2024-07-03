package equityGroupCodility

data class Product(val id: String, val quantity: Int)

fun calculateTotalPrice(products: List<Product>): Double {
    var totalPrice = 0.0

    for (product in products) {
        totalPrice += when {
            product.quantity < 10 -> product.quantity * 10.0
            product.quantity in 10..50 -> product.quantity * 9.0
            else -> product.quantity * 8.0
        }
    }

    val totalValue = totalPrice
    if (totalValue > 100) {
        totalPrice *= 0.9 // Apply 10% discount
    }

    return totalPrice
}

fun main() {
    val products = listOf(Product("1", 5), Product("2", 20), Product("3", 60))
    val totalPrice = calculateTotalPrice(products)
    println("Total Price: $$totalPrice")
}