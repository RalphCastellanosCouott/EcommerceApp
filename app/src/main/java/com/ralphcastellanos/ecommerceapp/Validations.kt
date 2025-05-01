package com.ralphcastellanos.ecommerceapp

import android.util.Patterns

//retornar un true si es válido y un false si no es válido
//también retornar una cadena que me diga qué pasó si no es válido
fun validateEmail(email: String): Pair<Boolean, String>{
    return when{
        email.isEmpty() -> Pair(false, "El correo es requerido")
        !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> Pair(false, "El correo es inválido")
        email.endsWith("@unab.edu.co")-> Pair(false, "Ese email no es de la UNAB")
        else -> Pair(true, "")
    }
}

fun validatePassword(password:String): Pair<Boolean, String>{
    return when{
        password.isEmpty() -> Pair(false, "La contraseña es requerida")
        password.length < 6 -> Pair(false, "La contraseña debe tener al menos 6 caracteres")
        !password.any {it.isDigit()} -> Pair(false, "La contraseña debe tener un dígito")
        else -> Pair(true, "")
    }
}

fun validateName(name:String): Pair<Boolean, String>{
    return  when{
        name.isEmpty() -> Pair(false, "El nombre es requerido")
        name.length < 3 -> Pair(false, "El nombre debe tener al menos 3 caracteres")
        else -> Pair(true, "")
    }
}

fun validateConfirmationPassword(password: String, confirmPassword: String): Pair<Boolean, String>{
    return when{
        confirmPassword.isEmpty() -> Pair(false, "La contraseña es requerida")
        confirmPassword != password -> Pair(false, "Las contraseñas no coinciden")
        else -> Pair(true, "")
    }
}