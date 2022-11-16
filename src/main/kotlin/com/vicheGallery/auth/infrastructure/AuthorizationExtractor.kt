package com.vicheGallery.auth.infrastructure

import java.util.*
import javax.servlet.http.HttpServletRequest

class AuthorizationExtractor {

    companion object {
        private const val AUTHORIZATION = "Authorization"
        private const val BEARER_TYPE = "Bearer"
        private val ACCESS_TOKEN_TYPE = AuthorizationExtractor::class.java.simpleName + ".ACCESS_TOKEN_TYPE"

        fun extract(request: HttpServletRequest): String? {
            val headers = request.getHeaders(AUTHORIZATION)
            while (headers.hasMoreElements()) {
                val value = headers.nextElement()
                if (value.lowercase(Locale.getDefault()).startsWith(BEARER_TYPE.lowercase(Locale.getDefault()))) {
                    var authHeaderValue = value.substring(BEARER_TYPE.length).trim { it <= ' ' }
                    request.setAttribute(ACCESS_TOKEN_TYPE, value.substring(0, BEARER_TYPE.length).trim { it <= ' ' })
                    val commaIndex = authHeaderValue.indexOf(',')
                    if (commaIndex > 0) {
                        authHeaderValue = authHeaderValue.substring(0, commaIndex)
                    }
                    return authHeaderValue
                }
            }
            return null
        }
    }
}