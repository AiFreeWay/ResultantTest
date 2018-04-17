package tech.intom.resultanttest.application.exceptions

import java.io.PrintWriter
import java.io.StringWriter
import tech.intom.resultanttest.application.Logger
import tech.intom.resultanttest.application.ResultantApp
import tech.intom.resultanttest.domain.executors.ExceptionExecutor
import javax.inject.Inject

/**
 * Created by root on 10.04.18.
 */
class ExceptionHandler(private val mApplication: ResultantApp) : Thread.UncaughtExceptionHandler {

    @Inject lateinit var mExceptionExecutor: ExceptionExecutor

    companion object {

        private val STRING_WRITER: StringWriter = StringWriter()
        private val PRINT_WRITER : PrintWriter = PrintWriter(STRING_WRITER)

        fun handleException(exception: Throwable) {
            exception.printStackTrace(PRINT_WRITER)
            PRINT_WRITER.flush()
            Logger.logError(STRING_WRITER.toString())
        }
    }

    init {
        mApplication.getRootComponent().inject(this)

        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    override fun uncaughtException(t: Thread?, e: Throwable) {
        val currentActivity = mApplication.getCurrentActivity()

        if (currentActivity != null) {
            currentActivity.finish()
        }

        handleException(e)

        if (mExceptionExecutor.isExceptionAllowed(e)) {
            mExceptionExecutor.restartApp()
        }

        System.exit(-1)
    }
}