package tech.intom.resultanttest.presentation.screens.currency

import com.arellomobile.mvp.InjectViewState
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import tech.intom.resultanttest.application.Logger
import tech.intom.resultanttest.application.exceptions.ExceptionMessageFactory
import tech.intom.resultanttest.application.models.Currency
import tech.intom.resultanttest.domain.executors.CurrencyExecutor
import tech.intom.resultanttest.presentation.screens.abstractions.BasePresenter
import tech.intom.resultanttest.presentation.screens.abstractions.CurrencyView
import tech.intom.resultanttest.presentation.utils.ModelFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by root on 16.04.18.
 */
@InjectViewState
class CurrencyPresenter : BasePresenter<CurrencyView>() {

    @Inject lateinit var mCurrencyExecutor: CurrencyExecutor

    init {
        Logger.logObjectCreating(this)
    }

    override fun attachView(view: CurrencyView?) {
        super.attachView(view)
        initCurrencyLoadInterval()
    }

    fun getCurrency() {
        mDisposables.add(mCurrencyExecutor.getCurrency()
                .doOnSubscribe({ onLoading() })
                .subscribe(this::onLoaded, this::onException))
    }

    private fun initCurrencyLoadInterval() {
        mDisposables.add(Observable.interval(0,15, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ getCurrency() }, this::handleException))
    }

    private fun onLoading() {
        viewState.loadModel(ModelFactory.createLoadingModel())
    }

    private fun onLoaded(payments: List<Currency>) {
        viewState.loadModel(ModelFactory.createLoadedDataModel(payments))
    }

    private fun onException(exception: Throwable) {
        handleException(exception)

        viewState.loadModel(ModelFactory.createErrorModel(exception))
    }
}