package tech.intom.resultanttest.presentation.adapters.holders

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import tech.intom.resultanttest.R
import tech.intom.resultanttest.application.models.Currency

/**
 * Created by root on 11.04.18.
 */
class CurrencyHolder : BaseHolder<Currency> {

    constructor(context: Context) : super(context, null)

    constructor(view: View) : super(view, null)

    override fun create(viewGroup: ViewGroup): BaseHolder<Currency> {
        val view = viewInflater(viewGroup, R.layout.h_currency)
        return CurrencyHolder(view)
    }

    override fun bind(dataModel: Currency) {

        itemView.findViewById<TextView>(R.id.h_currency_tv_name).setText(dataModel.name)
        itemView.findViewById<TextView>(R.id.h_currency_tv_volume).setText(dataModel.volume)
        itemView.findViewById<TextView>(R.id.h_currency_tv_amount).setText(dataModel.amount)
    }
}