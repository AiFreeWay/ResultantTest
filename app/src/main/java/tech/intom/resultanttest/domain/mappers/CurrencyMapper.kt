package tech.intom.resultanttest.domain.mappers

import tech.intom.resultanttest.application.models.Currency
import tech.intom.resultanttest.data.models.CurrencyData
import tech.intom.resultanttest.data.network.Responses.CurrencyResponse

/**
 * Created by root on 17.04.18.
 */
object CurrencyMapper {

    fun mapCurrencyList(currencyResponse: CurrencyResponse): List<Currency> {
        val currency = ArrayList<Currency>()

        currencyResponse.stock.forEach {
            currency.add(mapCurrency(it))
        }

        return currency
    }

    fun mapCurrency(currencyData: CurrencyData): Currency {
        return Currency(currencyData.name,
                currencyData.volume.toString(),
                currencyData.price?.amount.toString())
    }
}