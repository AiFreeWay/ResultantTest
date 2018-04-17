package tech.intom.resultanttest.presentation.screens.currency

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fmt_currency.*
import tech.intom.resultanttest.R
import tech.intom.resultanttest.application.Logger
import tech.intom.resultanttest.application.dependensy_injection.components.DaggerCurrencyComponent
import tech.intom.resultanttest.application.dependensy_injection.modules.CurrencyModule
import tech.intom.resultanttest.application.models.Currency
import tech.intom.resultanttest.presentation.adapters.MultyRvAdapter
import tech.intom.resultanttest.presentation.adapters.holders.CurrencyHolder
import tech.intom.resultanttest.presentation.models.Model
import tech.intom.resultanttest.presentation.screens.abstractions.CurrencyView
import tech.intom.resultanttest.presentation.screens.abstractions.FragmentChild
import tech.intom.resultanttest.presentation.screens.main.MainActivity

/**
 * Created by root on 16.04.18.
 */
class CurrencyFragment : MvpAppCompatFragment(), CurrencyView, FragmentChild<MainActivity> {

    @InjectPresenter
    internal lateinit var mPresenter: CurrencyPresenter

    private lateinit var mAdapter: MultyRvAdapter<Currency>

    private var mOnEmptyData = { isEmpty: Boolean ->
        if (isEmpty) {
            fmt_currency_tv_no_data.visibility = View.VISIBLE
        } else {
            fmt_currency_tv_no_data.visibility = View.GONE
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Logger.logObjectCreating(this)
        return inflater.inflate(R.layout.fmt_currency, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        createComponent()

        mAdapter = MultyRvAdapter(CurrencyHolder(context!!), mOnEmptyData)

        fmt_currency_rv_list.layoutManager = LinearLayoutManager(context)
        fmt_currency_rv_list.adapter = mAdapter
    }

    override fun onStart() {
        super.onStart()
        getParentView().setUpdateMenuItemDelegat {
            mPresenter.getCurrency()
        }
    }

    override fun onStop() {
        super.onStop()
        getParentView().setUpdateMenuItemDelegat(null)
    }

    override fun loadModel(model: Model<List<Currency>>) {
        getParentView().setProgressState(model.isLoading)

        if (model.isSuccess) {
            mAdapter.loadData(model.data!!)
        } else if (model.isError) {
            getParentView().showErrorDialog(model.error!!)
        }
    }

    private fun createComponent() {
        val component  = DaggerCurrencyComponent.builder()
                .rootComponent(getParentView().getRootComponent())
                .currencyModule(CurrencyModule())
                .build()

        component.inject(mPresenter)
    }

    override fun getParentView() = activity as MainActivity
}