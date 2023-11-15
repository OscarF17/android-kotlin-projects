package alanis.jorge.testingprep


import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.Assert.assertFalse

class RegistrationUtilTest{
    @Test
    fun emptyUsername() {
        val result = RegistrationUtil.validateRegistrationInput(
            username = "",
            password = "123456",
            confirmedPassword = "123456"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun validUsername() {
        val result = RegistrationUtil.validateRegistrationInput(
            username = "Jorge",
            password = "123456",
            confirmedPassword = "123456"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun existingUsername() {
        val result = RegistrationUtil.validateRegistrationInput(
            username = "Pedro",
            password = "123456",
            confirmedPassword = "123456"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun mismatchPassword() {
        val result = RegistrationUtil.validateRegistrationInput(
            username = "Jorge",
            password = "abcdef",
            confirmedPassword = "123456"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun emptyPassword() {
        val result = RegistrationUtil.validateRegistrationInput(
            username = "Jorge",
            password = "",
            confirmedPassword = ""
        )
        assertThat(result).isFalse()
    }


    @Test
    fun incompletePassword() {
        val result = RegistrationUtil.validateRegistrationInput(
            username = "Jorge",
            password = "123",
            confirmedPassword = "123"
        )
        assertThat(result).isFalse()
    }

}
