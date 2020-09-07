package com.chirag.randompeoplecarouseltest.networking

import retrofit2.Response


/**
 * Created by Chirag Sidhiwala on 7/7/20.
 */
sealed class ServerResponse<T> {
    class Loading<T> : ServerResponse<T>()
    class Loaded<T>() : ServerResponse<T>()
    data class Success<T>(val data: T) : ServerResponse<T>()
    data class Error<T>(val response: Response<T>) : ServerResponse<T>()

    companion object {
        fun <T> loading() = Loading<T>()
        fun <T> loaded() = Loaded<T>()
        fun <T> success(data: T) = Success<T>(data)
        fun <T> error(response: Response<T>) = Error<T>(response)
    }
}