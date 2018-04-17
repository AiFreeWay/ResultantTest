package tech.intom.kopilka.application


/**
 * Created by root on 09.04.18.
 */
class InvalidFragmentException : Exception(EXCEPTION_MESSAGE) {

    companion object {

        val EXCEPTION_MESSAGE = "Invalid fragment tag"
    }
}