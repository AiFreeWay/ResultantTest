package tech.intom.resultanttest.presentation.screens.main

import android.content.Context
import com.arellomobile.mvp.InjectViewState
import ru.terrakok.cicerone.Router
import tech.intom.resultanttest.application.Logger
import tech.intom.resultanttest.application.exceptions.ExceptionMessageFactory
import tech.intom.resultanttest.presentation.screens.abstractions.BasePresenter
import tech.intom.resultanttest.presentation.screens.abstractions.MainView
import tech.intom.resultanttest.presentation.utils.navigator.FragmentFactory
import javax.inject.Inject

/**
 * Created by root on 16.04.18.
 */
@InjectViewState
class MainPresenter : BasePresenter<MainView>() {

    @Inject lateinit var mFragmentRouter: Router

    init {
        Logger.logObjectCreating(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        mFragmentRouter.newRootScreen(FragmentFactory.CURRENCY_FRAGMENT_TAG)
    }

    fun backNavigate() {
        mFragmentRouter.exit()
    }

    fun getMessageByException(exception: Throwable, context: Context): String {
        return ExceptionMessageFactory.getMessageByException(exception, context)
    }
}