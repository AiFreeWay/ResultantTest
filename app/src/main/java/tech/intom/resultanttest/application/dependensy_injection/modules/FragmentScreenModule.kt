package tech.intom.resultanttest.application.dependensy_injection.modules

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import tech.intom.resultanttest.application.Logger
import tech.intom.resultanttest.application.dependensy_injection.scopes.PerFragmentsScreen
import tech.intom.resultanttest.presentation.utils.navigator.FragmentNavigator
import tech.intom.resultanttest.presentation.screens.abstractions.FragmentsScreen

/**
 * Created by root on 09.04.18.
 */
@Module
class FragmentScreenModule(fragmentScreen: FragmentsScreen) {

    private val mFragmentRouter: Router

    init {
        Logger.logObjectCreating(this)

        val cicerone = Cicerone.create()
        cicerone.navigatorHolder.setNavigator(FragmentNavigator(fragmentScreen))

        mFragmentRouter = cicerone.router
    }

    @Provides
    @PerFragmentsScreen
    fun provideFragmentRouter(): Router = mFragmentRouter
}