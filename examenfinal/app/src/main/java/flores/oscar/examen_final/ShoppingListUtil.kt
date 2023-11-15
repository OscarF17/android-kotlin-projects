// 570390 Oscar Luciano Flores Leija

package flores.oscar.examen_final

object ShoppingListUtil {
    /**
     * Verifica que el nombre del artículo no esté vacío y que la cantidad sea un número válido.
     */
    fun validateShoppingListItem(itemName: String, quantity: String): Boolean {

        // Espacios vacíos
        if(itemName.isBlank() ||  quantity.isBlank() || itemName.isEmpty() || quantity.isEmpty()) {
            return false
        }
        // Número inválido, no se puede convertir a int
        if(quantity.toIntOrNull() == null) {
            return false
        }

        // Happy path (todo bien)
        return true
    }
}