package levkaantonov.com.study.jetpacknavigation

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import levkaantonov.com.study.jetpacknavigation.fragments.BoxFragment


typealias ResultListener<T> = (T) -> Unit

fun <T> Fragment.publishResults(key: String, result: T) {
    findNavController().previousBackStackEntry?.savedStateHandle?.set(key, result)
}

fun <T> Fragment.listenResults(key: String, listener: ResultListener<T>) {
    val liveData =
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<T>(key)
    liveData?.observe(viewLifecycleOwner) {
        if (it != null) {
            listener(it)
            liveData.value = null
        }
    }
}