package com.app.lerp.data.network.util

import android.util.Log
import com.app.lerp.core.BaseException
import com.app.lerp.core.ConstantsCore.Error.HttpCode
import com.app.lerp.core.ConstantsCore.Error.Message
import com.app.lerp.core.model.EventResult
import com.google.gson.Gson
import retrofit2.Response


//fun <T, R> Response<BaseResponse<T>>?.validateResponse(
fun <T, R> Response<T>?.validateResponse(
    transform: T.() -> R,
): EventResult<R> {
    try {
        this?.let { response ->
            val errorBody: String? = response.errorBody()?.string()
            if (response.isSuccessful && errorBody.isNullOrEmpty()) {
                //val responseBody: BaseResponse<T>? = response.body()
                val responseBody: T? = response.body()
                //return responseBody?.data?.let { data ->
                return responseBody?.let { data ->
                    EventResult.Success(transform.invoke(data))
                }?: kotlin.run {
                    Log.i(
                        "BaseResponse ",
                        "responseBody:: Error con codigo diferete de 200 "
                    )
                    EventResult.Error(BaseException.GeneralException())
                }
                /*if (responseBody?.success == true) {
                    Log.i("BaseResponse ", "responseBody:: true")
                    return responseBody.data?.let { data ->
                        Log.i("BaseResponse ", "responseBody:: data esta lleno")
                        EventResult.Success(transform.invoke(data))
                    } ?: kotlin.run {
                        Log.i("BaseResponse ", "responseBody:: data esta  nulo ")
                        if (responseBody.code in 200..299) {
                            Log.i(
                                "BaseResponse ",
                                "responseBody:: data esta  nulo pero respondio code 200"
                            )
                            try {
                                EventResult.Success(Unit as R)
                            } catch (_: Exception) {
                                Log.i(
                                    "BaseResponse ",
                                    "responseBody:: Error pero respondio code 200 "
                                )
                                EventResult.Error(BaseException.GeneralException())
                            }
                        } else {
                            Log.i(
                                "BaseResponse ",
                                "responseBody:: Error con codigo diferete de 200 "
                            )
                            EventResult.Error(BaseException.GeneralException())
                        }
                    }
                } else {
                    Log.i("BaseResponse ", "responseBody:: false")
                    return EventResult.Error(
                        returnException(responseBody?.code, responseBody?.error?.errorMessage)
                    )
                }*/
            } else {
                Log.i("BaseResponse ", "responseBody:: ERROROR")
                val responseBody = Gson().fromJson(errorBody, BaseResponse::class.java)
                Log.i(
                    "BaseResponse ",
                    "responseBody:: responseBody" + responseBody.error?.errorMessage
                )
                if (code() == 401) {
                    return EventResult.Error(BaseException.GeneralException(code().toString()))
                }

                Log.i("BaseResponse ", "responseBody:: responseBody   code()" + code())
                return EventResult.Error(BaseException.GeneralException(responseBody.error?.errorMessage!!))

                /*return EventResult.Error(
                    returnException(code(), responseBody?.message)
                )*/
            }
        } ?: kotlin.run {
            Log.i("BaseResponse ", "responseBody:: ERROROR 2")
            return EventResult.Error(BaseException.GeneralException())
        }
    } catch (ex: Exception) {
        Log.i("BaseResponse ", "responseBody:: ERROROR 3")
        return EventResult.Error(BaseException.GeneralException())
    }
}

private fun returnException(code: Int?, message: String?): BaseException {
    return when (code) {
        HttpCode.BAD_REQUEST -> BaseException.BadRequestException(
            message ?: Message.GENERAL_ERROR_MESSAGE
        )
        HttpCode.UNAUTHORIZED -> BaseException.UnAuthorizeException()
        else -> BaseException.GeneralException(Message.GENERAL_ERROR_MESSAGE)
    }
}

fun String?.notNull(): String {
    return this ?: ""
}

fun Int?.notNull(): Int {
    return this ?: 0
}

fun Boolean?.notNull(): Boolean {
    return this ?: false
}


