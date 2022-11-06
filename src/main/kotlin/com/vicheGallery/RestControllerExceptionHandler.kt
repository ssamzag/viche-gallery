package com.vicheGallery

import com.vicheGallery.exceptionResponse.dto.ErrorResponse
import com.vicheGallery.exceptionResponse.dto.Error
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
            return ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Valid Error",
                getErrorList(e)
            )
        }

        return ErrorResponse(HttpStatus.BAD_REQUEST.value(), "")
    }

    private fun getErrorList(e: MethodArgumentNotValidException) =
        e.fieldErrors
            .map { Error(it.field, it.defaultMessage) }
            .toList()


}
