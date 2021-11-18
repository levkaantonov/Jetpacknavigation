package levkaantonov.com.study.jetpacknavigation.screens.main.tabs.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import levkaantonov.com.study.jetpacknavigation.model.accounts.Account
import levkaantonov.com.study.jetpacknavigation.model.accounts.AccountsRepository
import levkaantonov.com.study.jetpacknavigation.utils.MutableLiveEvent
import levkaantonov.com.study.jetpacknavigation.utils.publishEvent
import levkaantonov.com.study.jetpacknavigation.utils.share

class ProfileViewModel(
    private val accountsRepository: AccountsRepository
) : ViewModel() {

    private val _account = MutableLiveData<Account>()
    val account = _account.share()

    private val _restartFromLoginEvent = MutableLiveEvent<Unit>()
    val restartWithSignInEvent = _restartFromLoginEvent.share()

    init {
        viewModelScope.launch {
            accountsRepository.getAccount().collect { _account.value = it }
        }
    }

    fun logout() {
        accountsRepository.logout()
        restartAppFromLoginScreen()
    }

    private fun restartAppFromLoginScreen() {
        _restartFromLoginEvent.publishEvent()
    }

}