package com.vicheGallery.post.dto

import java.time.LocalDateTime

data class PostRead(
    val title: String,
    val content: String,
    val createdDate: LocalDateTime,
    val modifiedData: LocalDateTime
)
