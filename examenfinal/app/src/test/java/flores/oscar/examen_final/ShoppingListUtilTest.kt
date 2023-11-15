// 570390 Oscar Luciano Flores Leija

package flores.oscar.examen_final

import org.junit.Test
import com.google.common.truth.Truth.assertThat

class ShoppingListUtilTest {
    // Happy path, datos correctos
    @Test
    fun happyPath() {
        val result = ShoppingListUtil.validateShoppingListItem(
            itemName = "Producto",
            quantity = "2"
        )
        assertThat(result).isTrue()
    }

    // Nombre vacío
    @Test
    fun emptyItem() {
        val result = ShoppingListUtil.validateShoppingListItem(
            itemName = "",
            quantity = "2"
        )
        assertThat(result).isFalse()
    }

    // Número inváido
    @Test
    fun invalidNumber() {
        val result = ShoppingListUtil.validateShoppingListItem(
            itemName = "Producto",
            quantity = "abc"
        )
        assertThat(result).isFalse()
    }

}