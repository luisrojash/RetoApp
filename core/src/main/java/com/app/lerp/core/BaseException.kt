package com.app.lerp.core

import java.io.IOException

sealed class BaseException(
    errorMessage: String
) : IOException(errorMessage) {

    data class GeneralException(
        var errorMessage: String = ConstantsCore.Error.Message.GENERAL_ERROR_MESSAGE,
    ) : BaseException(errorMessage)

    data class AirplaneException(
        var errorMessage: String
    ) : BaseException(errorMessage)

    data class NetworkException(
        var errorMessage: String
    ) : BaseException(errorMessage)

    data class BadRequestException(
        var errorMessage: String
    ) : BaseException(errorMessage)

    data class UnAuthorizeException(
        var errorMessage: String = ConstantsCore.Error.Message.UNAUTHORIZE_MESSAGE
    ) : BaseException(errorMessage)

    data class PushNotificationTokenException(
        var errorMessage: String = ConstantsCore.Error.Message.PUSH_TOKEN_MESSAGE
    ) : BaseException(errorMessage)
}
