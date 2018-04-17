package tech.intom.resultanttest.application.dependensy_injection.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import tech.intom.resultanttest.application.Logger
import tech.intom.resultanttest.data.central_repository.Repository
import tech.intom.resultanttest.data.central_repository.abstractions.*
import tech.intom.resultanttest.data.network.NetworkController
import tech.intom.resultanttest.data.shared_preference.PreferenceStore
import tech.intom.resultanttest.domain.executors.ExceptionExecutor
import javax.inject.Singleton

/**
 * Created by root on 09.04.18.
 */
@Module
class RootModule(private val mContext: Context) {

    init {
        Logger.logObjectCreating(this)
    }

    @Provides
    @Singleton
    fun  provideContext(): Context = mContext

    @Provides
    @Singleton
    fun providePreferenseStore(): PreferenceStore = PreferenceStore()

    @Provides
    @Singleton
    fun provideNetworkController(): NetworkController = NetworkController()

    @Provides
    @Singleton
    fun provideExceptionRepository(repository : Repository): ExceptionRepository = repository

    @Provides
    @Singleton
    fun provideExceptionExecutor(repository : ExceptionRepository, context: Context) = ExceptionExecutor(repository, context)
}