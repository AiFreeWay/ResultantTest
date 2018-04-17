package tech.intom.resultanttest.data.central_repository

import tech.intom.parrotwings.application.exceptions.ExceptionStoreModel
import tech.intom.resultanttest.application.Logger
import tech.intom.resultanttest.data.central_repository.abstractions.CurrencyRepository
import tech.intom.resultanttest.data.central_repository.abstractions.ExceptionRepository
import tech.intom.resultanttest.data.network.NetworkController
import tech.intom.resultanttest.data.shared_preference.PreferenceStore
import javax.inject.Inject

/**
 * Created by root on 09.04.18.
 */
class Repository @Inject constructor(private val mNetworkController: NetworkController,
                                     private val mPreferenceStore: PreferenceStore) :
        ExceptionRepository, CurrencyRepository {

    init {
        Logger.logObjectCreating(this)
    }

    //Exceptions Repository

    override fun getExceptions() = mPreferenceStore.getExceptions()

    override fun putExceptions(exceptionsModel: ExceptionStoreModel) {
        mPreferenceStore.putException(exceptionsModel)
    }

    //CurrencyData Repository

    override fun getCurrency() = mNetworkController.getPosts()
}