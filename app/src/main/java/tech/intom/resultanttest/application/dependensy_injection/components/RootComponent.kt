package tech.intom.resultanttest.application.dependensy_injection.components

import android.content.Context
import dagger.Component
import tech.intom.resultanttest.application.dependensy_injection.modules.RootModule
import tech.intom.resultanttest.application.exceptions.ExceptionHandler
import tech.intom.resultanttest.data.central_repository.abstractions.ExceptionRepository
import tech.intom.resultanttest.data.network.NetworkController
import tech.intom.resultanttest.data.shared_preference.PreferenceStore

import javax.inject.Singleton

/**
 * Created by root on 09.04.18.
 */
@Singleton
@Component(modules = arrayOf(RootModule::class))
interface RootComponent {

    fun provideContext() : Context
    fun provideExceptionRepository() : ExceptionRepository
    fun providePreferenseStore() : PreferenceStore
    fun provideNetworkController() : NetworkController

    fun inject(exceptionHandler: ExceptionHandler)
}