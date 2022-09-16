package com.app.lerp.usecase.usecase

import com.app.lerp.core.model.EventResult
import javax.inject.Inject

class UserUseCase @Inject constructor(){


     fun initLogin(usuario: String, clave: String): EventResult<String> {
        if (usuario.trim() != "Admin") {
            return EventResult.Error(Exception("Usuario Invalido"))
        }
        if (clave.trim() != "Password*123") {
            return EventResult.Error(Exception("Clave Invalido"))
        }
        if (usuario.trim() == "Admin" && clave.trim() == "Password*123") {
            return EventResult.Success("Datos correctos")
        }
        return EventResult.Error(Exception("Ocurrio algo inesperado"))
    }


}