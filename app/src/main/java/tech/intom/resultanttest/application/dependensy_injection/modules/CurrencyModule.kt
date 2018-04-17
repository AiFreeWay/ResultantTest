package tech.intom.resultanttest.application.dependensy_injection.modules

import dagger.Module
import dagger.Provides
import tech.intom.resultanttest.application.Logger
import tech.intom.resultanttest.application.dependensy_injection.scopes.PerCurrency
import tech.intom.resultanttest.data.central_repository.Repository
import tech.intom.resultanttest.data.central_repository.abstractions.CurrencyRepository
import tech.intom.resultanttest.domain.executors.CurrencyExecutor

/**
 * Created by root on 10.04.18.
 */
@Module
class CurrencyModule {

    init {
        Logger.logObjectCreating(this)
    }

    @Provides
    @PerCurrency
    fun provideCurrencyRepository(repository : Repository): CurrencyRepository = repository

    @Provides
    @PerCurrency
    fun provideCurrencyExecutor(repository: CurrencyRepository) = CurrencyExecutor(repository)
}