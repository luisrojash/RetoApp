package com.app.lerp.core

import java.util.Locale

object ConstantsCore {
    object BuildTypes {
        const val RELEASE : String = "release"
        const val DEBUG   : String = "debug"
    }

    object Server {
        const val GOOGLE_VARIANT: String = "google"
        const val HUAWEI_VARIANT: String = "huawei"
        const val BEARER: String = "Bearer"
        const val ANDROID_PLATFORM: String = "android"
        const val HUAWEI_PLATFORM: String = "huawei"
        const val TIMEOUT: Long = 180L
        const val AUTHORIZATION: String = "Authorization"
        const val X_OS: String = "X-Os"
        const val X_VERSION: String = "x-version"
    }

    object Error {
        object HttpCode {
            const val BAD_REQUEST = 400
            const val UNAUTHORIZED = 401
        }

        object Message {
            const val GENERAL_ERROR_MESSAGE = "Ocurrió un error inesperado"
            const val UNAUTHORIZE_MESSAGE = "Su sesión ha finalizado"
            const val AIRPLANE_ERROR_MESSAGE = "Su sesión ha finalizado"
            const val PUSH_TOKEN_MESSAGE = "Hubo un problema obteniendo el token de notificación"
        }
    }

    object DatePattern {
        const val ddMMyyyy_slashes = "dd/MM/yyyy"
        const val ddMMyyyy = "dd-MM-yyyy"
        const val yyyyMMdd = "yyyy-MM-dd"
        const val yyyyMMddHHmm = "yyyy-MM-dd HH:mm"
        const val dayAndMonth = "dd MMMM"
        const val dayAndMonthShort = "dd MMM"
        const val dayDateAndMonth = "EEEE dd 'de' MMMM"
        const val dateMonthAndYear = "dd 'de' MMMM, yyyy"
        const val dayMonthYear = "dd MMMM yyyy"
        const val monthAndYear = "MMMM yyyy"
        const val hourOnly = "HH:mm"
        const val hourAmOrPm = "HH:mm a"
        const val hourTwelveOnly = "hh:mm"
        const val hourTwelveAmOrPm = "hh:mm a"
        const val monthNameShort = "MMM"
        const val monthNameComplete = "MMMM"
        const val amOrPm = "a"
        const val dayOnly = "dd"
        const val dateAndHourTwelveAmOrPm = "dd/MM/yyyy hh:mm a"
    }

    object Packages {
        const val WAZE = "com.waze"
        const val WHATSAPP = "com.whatsapp"
        const val GOOGLE_MAPS = "com.google.android.apps.maps"
    }


    object Locale {
        val AmountsLocale = Locale("en", "US")
        val Spanish = Locale("es")
    }

    object Currency {
        const val PEN: String = "S/"
        const val USD: String = "$"
    }
}