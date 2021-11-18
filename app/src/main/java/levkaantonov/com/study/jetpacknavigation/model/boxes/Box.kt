package levkaantonov.com.study.jetpacknavigation.model.boxes

import androidx.annotation.StringRes

data class Box(
    val id: Int,
    @StringRes val colorNameRes: Int,
    val colorValue: Int
)