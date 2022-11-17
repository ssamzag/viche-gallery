package com.vicheGallery.work.dto

data class WorkReadResponse(
    val workId: Long?,
    val title: String,
    val content: String,
    val attachments: List<String>?
)
