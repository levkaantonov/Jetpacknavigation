package levkaantonov.com.study.jetpacknavigation.screens.main.tabs.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import levkaantonov.com.study.jetpacknavigation.model.boxes.Box
import levkaantonov.com.study.jetpacknavigation.model.boxes.BoxesRepository
import levkaantonov.com.study.jetpacknavigation.utils.share

class DashboardViewModel(
    private val boxesRepository: BoxesRepository
) : ViewModel() {

    private val _boxes = MutableLiveData<List<Box>>()
    val boxes = _boxes.share()

    init {
        viewModelScope.launch {
            boxesRepository.getBoxes(onlyActive = true).collect { _boxes.value = it }
        }
    }

}