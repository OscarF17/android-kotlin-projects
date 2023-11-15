package alanis.jorge.testingprep

object RegistrationUtil {

    private val existingUsers = listOf("Pedro", "Juan")

    /**
     * username / pass empty
     * username is already taken
     * confirmed password is not same as real password
     * password contains less than 6 digits
     *
     */

    fun validateRegistrationInput(
        username: String,
        password: String,
        confirmedPassword: String
    ): Boolean{
        if(username.isEmpty() || password.isEmpty() || confirmedPassword.isEmpty()){
            return false
        }
        if(username in existingUsers){
            return false
        }
        if(password != confirmedPassword){
            return false
        }
        if(password.count() < 6){
            return false
        }
        return true

    }
}