package com.vicheGallery.exceptionResponse.dto

class ErrorResponse(
    val code: Int,
    val message: String?,
    val validation: List<Error> = listOf()
) {
}
