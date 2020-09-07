package com.chirag.randompeoplecarouseltest.networking

import android.text.TextUtils
import androidx.annotation.MainThread
import kotlinx.coroutines.flow.flow
import okhttp3.ResponseBody
import retrofit2.Response


/**
 * Created by Chirag Sidhiwala on 7/7/20.
 */
//This is Network Bound Repository which Parse network response and convert it with ServerResponse
abstract class NetworkBoundRepository<T> {
    fun asFlow() = flow<ServerResponse<T>> {

        // Emit Loading State
        emit(ServerResponse.loading())

        try {
            // Fetch latest data from remote
            val apiResponse = getDataFromServer()

            // Parse body
            val responseBody = apiResponse.body()

            // Check for response validation
            if (apiResponse.isSuccessful && responseBody != null) {
                emit(ServerResponse.success(responseBody))
            } else {
                // Something went wrong! Emit Error state.
                emit(ServerResponse.error(apiResponse))
            }
        } catch (e: Exception) {
            // Exception occurred! Emit error
            val exceptionMessage = e.message
            val response: Response<T>
            if (!TextUtils.isEmpty(exceptionMessage)) {
                response = Response.error(
                    503,
                    ResponseBody.create(null, exceptionMessage!!)
                )
            } else {
                response = Response.error(
                    503,
                    ResponseBody.create(null, "Internet connection is not available.")
                )
            }
            emit(ServerResponse.error(response))
            e.printStackTrace()
        }
    }

    @MainThread
    protected abstract suspend fun getDataFromServer(): Response<T>
}