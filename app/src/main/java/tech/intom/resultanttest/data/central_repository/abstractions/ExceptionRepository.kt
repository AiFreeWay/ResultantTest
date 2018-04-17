package tech.intom.resultanttest.data.central_repository.abstractions

import tech.intom.parrotwings.application.exceptions.ExceptionStoreModel

/**
 * Created by root on 10.04.18.
 */
interface ExceptionRepository {

    fun getExceptions(): Set<ExceptionStoreModel>
    fun putExceptions(exceptionsModel: ExceptionStoreModel)
}