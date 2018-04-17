package tech.intom.resultanttest.domain.executors

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tech.intom.resultanttest.application.Logger
import tech.intom.resultanttest.application.models.Currency
import tech.intom.resultanttest.data.central_repository.abstractions.CurrencyRepository
import tech.intom.resultanttest.domain.mappers.CurrencyMapper

/**
 * Created by root on 16.04.18.
 */
class CurrencyExecutor constructor(private val mRepository: CurrencyRepository) {

    init {
        Logger.logObjectCreating(this)
    }

    fun getCurrency(): Observable<List<Currency>> {
        return mRepository.getCurrency()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .map({ response -> CurrencyMapper.mapCurrencyList(response) })
    }
}