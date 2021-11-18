package levkaantonov.com.study.jetpacknavigation.model.boxes

import kotlinx.coroutines.flow.Flow

interface BoxesRepository {

    fun getBoxes(onlyActive: Boolean = false): Flow<List<Box>>

    suspend fun activateBox(box: Box)

    suspend fun deactivateBox(box: Box)

}