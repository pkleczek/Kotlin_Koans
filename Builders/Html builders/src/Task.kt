fun renderProductTable(): String {
    return html {
        table {
            tr(getTitleColor()) {
                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Popularity")
                }
            }
            val products = getProducts()
            products.forEachIndexed { i, p ->
                tr {
                    td(getCellColor(i, 0)) {
                        text(p.description)
                    }
                    td(getCellColor(i, 0)) {
                        text(p.price)
                    }
                    td(getCellColor(i, 0)) {
                        text(p.popularity)
                    }
                }
            }
        }
    }.toString()
}

fun getTitleColor() = "#b9c9fe"
fun getCellColor(index: Int, row: Int) = if ((index + row) % 2 == 0) "#dce4ff" else "#eff2ff"
