// 570390 Oscar Luciano Flores Leija

package flores.oscar.examen_final

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.matcher.ViewMatchers.*



import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityEspresoTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // Happy path, datos correctos
    @Test
    fun happyPath() {
        // Ingresar datos válidos
        onView(withId(R.id.itemNameEditText)).perform(ViewActions.typeText("Producto"))
        onView(withId(R.id.quantityEditText)).perform(ViewActions.typeText("1"))

        Espresso.closeSoftKeyboard()

        // Hacer clic en el botón de registro
        onView(withId(R.id.addButton)).perform(ViewActions.click())

        // Verificar que se muestra el mensaje de registro exitoso
        onView(withId(R.id.messageTextView)).check(ViewAssertions.matches(ViewMatchers.withText("Artículo añadido correctamente")))
    }

    // Porudcto vacío
    @Test
    fun validateBlankName() {
        // Ingresar datos válidos
        onView(withId(R.id.itemNameEditText)).perform(ViewActions.typeText(""))
        onView(withId(R.id.quantityEditText)).perform(ViewActions.typeText("1"))

        Espresso.closeSoftKeyboard()

        // Hacer clic en el botón de registro
        onView(withId(R.id.addButton)).perform(ViewActions.click())

        // Verificar que se muestra el mensaje de registro fallido
        onView(withId(R.id.messageTextView)).check(ViewAssertions.matches(ViewMatchers.withText("Error al agregar producto")))
    }

    // Número inválido
    @Test
    fun validateInvalidNumber() {
        // Ingresar datos válidos
        onView(withId(R.id.itemNameEditText)).perform(ViewActions.typeText("Producto"))
        onView(withId(R.id.quantityEditText)).perform(ViewActions.typeText("abc"))

        Espresso.closeSoftKeyboard()

        // Hacer clic en el botón de registro
        onView(withId(R.id.addButton)).perform(ViewActions.click())

        // Verificar que se muestra el mensaje de registro fallido
        onView(withId(R.id.messageTextView)).check(ViewAssertions.matches(ViewMatchers.withText("Error al agregar producto")))
    }


}