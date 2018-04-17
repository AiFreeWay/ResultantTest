package tech.intom.resultanttest.presentation.screens.abstractions

import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import tech.intom.resultanttest.application.dependensy_injection.components.RootComponent

/**
 * Created by root on 09.04.18.
 */
interface FragmentsScreen {

    fun getActivity(): AppCompatActivity
    fun getSupportFragmentManager(): FragmentManager
    fun getContainerId(): Int
    fun getRootComponent(): RootComponent
}