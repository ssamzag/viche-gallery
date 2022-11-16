package com.vicheGallery.auth.exception

import org.springframework.http.HttpStatus.UNAUTHORIZED
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(UNAUTHORIZED)
class AuthorizationException(message: String?): RuntimeException(message) {
}