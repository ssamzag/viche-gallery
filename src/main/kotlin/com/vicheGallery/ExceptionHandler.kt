package com.vicheGallery

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleIllegalArgsException(e: DataIntegrityViolationException?): ResponseEntity<*>? {
        return ResponseEntity.badRequest().build<Any>()
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgsException(e: IllegalArgumentException): ResponseEntity<*>? {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.message)
    }
}