package levkaantonov.com.study.jetpacknavigation.model.accounts

import kotlinx.coroutines.flow.Flow

interface AccountsRepository {

    suspend fun isSignedIn(): Boolean

    suspend fun signIn(email: String, password: String)

    suspend fun signUp(signUpData: SignUpData)

    fun logout()

    fun getAccount(): Flow<Account?>

    suspend fun updateAccountUsername(newUsername: String)

}