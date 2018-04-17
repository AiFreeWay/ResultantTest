package tech.intom.resultanttest.presentation.utils.navigator

import android.os.Bundle
import android.support.v4.app.Fragment
import ru.terrakok.cicerone.android.SupportFragmentNavigator
import tech.intom.resultanttest.application.Logger
import tech.intom.resultanttest.presentation.screens.abstractions.FragmentsScreen

/**
 * Created by root on 05.09.18.
 */
class FragmentNavigator(fragmentsScreen: FragmentsScreen) :
        SupportFragmentNavigator(
                fragmentsScreen.getSupportFragmentManager(),
                fragmentsScreen.getContainerId()) {

    private val mFragmentsScreen: FragmentsScreen = fragmentsScreen

    override public fun exit() {
        mFragmentsScreen.getActivity().finish()
    }

    override public fun createFragment(screenKey: String, data: Any?): Fragment {
        if (data != null && data is Bundle) {
            return FragmentFactory.createFragment(screenKey, data)
        } else {
            return FragmentFactory.createFragment(screenKey)
        }
    }

    override fun showSystemMessage(message: String) {
        Logger.log(message)
    }
}