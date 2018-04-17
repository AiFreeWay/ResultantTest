package tech.intom.resultanttest.application.dependensy_injection.components

import dagger.Component
import tech.intom.resultanttest.application.dependensy_injection.modules.FragmentScreenModule
import tech.intom.resultanttest.application.dependensy_injection.scopes.PerFragmentsScreen
import tech.intom.resultanttest.presentation.screens.main.MainPresenter

/**
 * Created by root on 09.04.18.
 */
@PerFragmentsScreen
@Component(modules = arrayOf(FragmentScreenModule::class), dependencies = arrayOf(RootComponent::class))
interface FragmentScreenComponent {

    fun inject(presenter: MainPresenter)
}