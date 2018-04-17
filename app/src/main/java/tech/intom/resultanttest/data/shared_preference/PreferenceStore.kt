package tech.intom.resultanttest.data.shared_preference

import android.text.TextUtils
import com.orhanobut.hawk.Hawk
import tech.intom.parrotwings.application.exceptions.ExceptionStoreModel


/**
 * Created by root on 09.04.18.
 */
class PreferenceStore {

    companion object {
        val EXCEPTIONS_TAG = "exceptions"
    }

    fun getExceptions() = Hawk.get<HashSet<ExceptionStoreModel>>(EXCEPTIONS_TAG, HashSet())

    fun putException(exceptionsModel: ExceptionStoreModel) {
        val exceptions = getExceptions()

        val findedException = exceptions.find {
            TextUtils.equals(it.exceptionTag, exceptionsModel.exceptionTag)
        }

        if (findedException != null) {
            exceptions.remove(findedException)
        }

        exceptions.add(exceptionsModel)
        Hawk.put(EXCEPTIONS_TAG, exceptions)
    }
}