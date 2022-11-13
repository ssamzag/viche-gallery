package com.vicheGallery.work.dto

data class WorkWriteRequest(
    val title: String,
    val content: String,
    val attachments: List<String>?
)