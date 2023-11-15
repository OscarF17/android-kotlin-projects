package alanis.jorge.testingprep


imporandroidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.closeSoftKeyboard

import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityEspresoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testRegistrationFlow_Successful() {
        // Ingresar datos válidos
        onView(withId(R.id.usernameEditText)).perform(typeText("NuevoUsuario"))
        onView(withId(R.id.passwordEditText)).perform(typeText("123456"))
        onView(withId(R.id.confirmPasswordEditText)).perform(typeText("123456"))

        closeSoftKeyboard()

        // Hacer clic en el botón de registro
        onView(withId(R.id.submitBtn)).perform(click())

        // Verificar que se muestra el mensaje de registro exitoso
        onView(withId(R.id.messageTextView)).check(matches(withText("Registro exitoso")))
    }


    @Test
    fun testRegistrationFlow_Failure() {
        // Ingresar datos inválidos
        onView(withId(R.id.usernameEditText)).perform(typeText("Pedro")) // Usuario existente
        onView(withId(R.id.passwordEditText)).perform(typeText("12345")) // Contraseña corta
        onView(withId(R.id.confirmPasswordEditText)).perform(typeText("12345"))

        closeSoftKeyboard()

        // Hacer clic en el botón de registro
        onView(withId(R.id.submitBtn)).perform(click())

        // Verificar que se muestra el mensaje de error en el registro
        onView(withId(R.id.messageTextView)).check(matches(withText("Error en el registro")))
    }

}

