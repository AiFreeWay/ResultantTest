package tech.intom.resultanttest.application.dependensy_injection.components

import dagger.Component
import tech.intom.resultanttest.application.dependensy_injection.modules.CurrencyModule
import tech.intom.resultanttest.application.dependensy_injection.scopes.PerCurrency
import tech.intom.resultanttest.data.central_repository.abstractions.CurrencyRepository
import tech.intom.resultanttest.presentation.screens.currency.CurrencyPresenter

/**
 * Created by root on 10.04.18.
 */
@PerCurrency
@Component(modules = arrayOf(CurrencyModule::class), dependencies = arrayOf(RootComponent::class))
interface CurrencyComponent {

    fun provideCurrencyRepository() : CurrencyRepository

    fun inject(presenter: CurrencyPresenter)
}