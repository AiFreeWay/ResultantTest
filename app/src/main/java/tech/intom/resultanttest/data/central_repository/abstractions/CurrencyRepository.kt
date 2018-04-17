package tech.intom.resultanttest.data.central_repository.abstractions

import io.reactivex.Observable
import tech.intom.resultanttest.data.network.Responses.CurrencyResponse

/**
 * Created by root on 09.04.18.
 */
interface CurrencyRepository {

    fun getCurrency(): Observable<CurrencyResponse>
}