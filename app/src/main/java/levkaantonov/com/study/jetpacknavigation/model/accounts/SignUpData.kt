package levkaantonov.com.study.jetpacknavigation.model.accounts

import levkaantonov.com.study.jetpacknavigation.model.EmptyFieldException
import levkaantonov.com.study.jetpacknavigation.model.Field
import levkaantonov.com.study.jetpacknavigation.model.PasswordMismatchException

data class SignUpData(
    val username: String,
    val email: String,
    val password: String,
    val repeatPassword: String
) {
    fun validate() {
        if (email.isBlank()) throw EmptyFieldException(Field.Email)
        if (username.isBlank()) throw EmptyFieldException(Field.Username)
        if (password.isBlank()) throw EmptyFieldException(Field.Password)
        if (password != repeatPassword) throw PasswordMismatchException()
    }
}