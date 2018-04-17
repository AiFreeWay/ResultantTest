package tech.intom.resultanttest.presentation.utils.navigator

import android.os.Bundle
import android.support.v4.app.Fragment
import tech.intom.kopilka.application.InvalidFragmentException
import tech.intom.resultanttest.presentation.screens.currency.CurrencyFragment

/**
 * Created by root on 09.04.18.
 */
object FragmentFactory {

    val CURRENCY_FRAGMENT_TAG = CurrencyFragment::class.java.canonicalName

    fun createFragment(tag: String): Fragment {
        return when(tag) {
            CURRENCY_FRAGMENT_TAG -> CurrencyFragment()
            else -> throw InvalidFragmentException()
        }
    }

    fun createFragment(tag: String, data: Bundle): Fragment {
        val fragment = createFragment(tag)
        fragment.arguments = data

        return fragment
    }
}