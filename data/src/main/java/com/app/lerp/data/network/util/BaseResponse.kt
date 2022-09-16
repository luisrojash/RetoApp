package com.app.lerp.data.network.util

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("success")
    var success: Boolean = false,
    @SerializedName("message")
    var message: String?,
    @SerializedName("code")
    var code: Int = -1,
    @SerializedName("results")
    var data: T?,
    @SerializedName("page")
    var page: Int?,
    @SerializedName("error")
    var error: BaseErrorResponse?
)
