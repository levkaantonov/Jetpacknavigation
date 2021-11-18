package levkaantonov.com.study.jetpacknavigation

import levkaantonov.com.study.jetpacknavigation.model.accounts.AccountsRepository
import levkaantonov.com.study.jetpacknavigation.model.accounts.InMemoryAccountsRepository
import levkaantonov.com.study.jetpacknavigation.model.boxes.BoxesRepository
import levkaantonov.com.study.jetpacknavigation.model.boxes.InMemoryBoxesRepository

object Repositories {

    val accountsRepository: AccountsRepository = InMemoryAccountsRepository()

    val boxesRepository: BoxesRepository = InMemoryBoxesRepository(accountsRepository)

}