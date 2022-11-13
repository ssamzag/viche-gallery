package com.vicheGallery.work.dto

data class WorkReadResponse(
    val title: String,
    val content: String,
    val attachments: List<String>?
)
