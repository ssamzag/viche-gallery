package com.vicheGallery

import com.vicheGallery.auth.exception.AuthorizationException
import com.vicheGallery.exceptionResponse.dto.ErrorResponse
import com.vicheGallery.exceptionResponse.dto.Error
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.Exception

@RestControllerAdvice
class RestControllerExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception::class)
    fun invalidRequestHandler(e: MethodArgumentNotValidException): ErrorResponse {
        if (e.hasErrors()) {
            return ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.message, getErrorList(e))
        }

        return ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.message)
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(FileSizeLimitExceededException::class)
    fun fileSizeLimitExceededHandler(e: MethodArgumentNotValidException): ErrorResponse {
        return ErrorResponse(HttpStatus.BAD_REQUEST.value(),  e.message, getErrorList(e)
        )
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthorizationException::class)
    fun authorizationHandler(e: AuthorizationException): ErrorResponse {
        return ErrorResponse(HttpStatus.UNAUTHORIZED.value(), e.message)
    }

    private fun getErrorList(e: MethodArgumentNotValidException) =
        e.fieldErrors
            .map { Error(it.field, it.defaultMessage) }
            .toList()

}
