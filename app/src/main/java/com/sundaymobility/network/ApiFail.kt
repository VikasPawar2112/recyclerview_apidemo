package com.sundaymobility.network

import retrofit2.HttpException
import rx.functions.Action1

import java.io.IOException
import java.net.ConnectException

abstract class ApiFail : Action1<Throwable> {
    override fun call(e: Throwable?) {
        try {
            if (e is HttpException) {
                val http = e as HttpException?
                val response = HttpErrorResponse(http!!.code(), http.response())
                response.error = http.message()
                httpStatus(response)
            } else if (e is ConnectException) {
                unknownError(e)
            } else if (e is IOException) {
                noNetworkError()
            } else {
                if (e != null) {
                    unknownError(e)
                }
            }
        } catch (e1: Exception) {
            if (e1 != null) {
                unknownError(e1)
            }
        }

    }

    abstract fun httpStatus(response: HttpErrorResponse)

    abstract fun noNetworkError()

    abstract fun unknownError(e: Throwable?)
}
