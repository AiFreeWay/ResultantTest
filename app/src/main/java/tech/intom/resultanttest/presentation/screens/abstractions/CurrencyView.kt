package tech.intom.resultanttest.presentation.screens.abstractions

import com.arellomobile.mvp.MvpView
import tech.intom.resultanttest.application.models.Currency
import tech.intom.resultanttest.presentation.models.Model

/**
 * Created by root on 16.04.18.
 */
interface CurrencyView : MvpView {

    fun loadModel(model: Model<List<Currency>>)
}