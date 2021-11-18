package levkaantonov.com.study.jetpacknavigation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import levkaantonov.com.study.jetpacknavigation.model.accounts.AccountsRepository
import levkaantonov.com.study.jetpacknavigation.utils.MutableLiveEvent
import levkaantonov.com.study.jetpacknavigation.utils.publishEvent
import levkaantonov.com.study.jetpacknavigation.utils.share

class SplashViewModel(
    private val accountsRepository: AccountsRepository
) : ViewModel() {

    private val _launchMainScreenEvent = MutableLiveEvent<Boolean>()
    val launchMainScreenEvent = _launchMainScreenEvent.share()

    init {
        viewModelScope.launch {
            _launchMainScreenEvent.publishEvent(accountsRepository.isSignedIn())
        }
    }
}