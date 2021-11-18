package levkaantonov.com.study.jetpacknavigation.screens.main.tabs.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import levkaantonov.com.study.jetpacknavigation.model.boxes.BoxesRepository
import levkaantonov.com.study.jetpacknavigation.utils.MutableLiveEvent
import levkaantonov.com.study.jetpacknavigation.utils.publishEvent
import levkaantonov.com.study.jetpacknavigation.utils.share

class BoxViewModel(
    private val boxId: Int,
    private val boxesRepository: BoxesRepository
) : ViewModel() {

    private val _shouldExitEvent = MutableLiveEvent<Boolean>()
    val shouldExitEvent = _shouldExitEvent.share()

    init {
        viewModelScope.launch {
            boxesRepository.getBoxes(onlyActive = true)
                .map { boxes -> boxes.firstOrNull { it.id == boxId } }
                .collect { currentBox -> _shouldExitEvent.publishEvent(currentBox == null) }
        }
    }
}