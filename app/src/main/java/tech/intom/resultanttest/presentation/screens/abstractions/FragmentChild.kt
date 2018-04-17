package tech.intom.resultanttest.presentation.screens.abstractions

/**
 * Created by root on 16.04.18.
 */
interface FragmentChild<ParentView: FragmentsScreen> {

    fun getParentView(): ParentView
}