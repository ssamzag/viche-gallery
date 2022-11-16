package com.vicheGallery.post.dto

import java.time.LocalDateTime

data class PostResponse(
    val id: Long?,
    val title: String,
    val content: String,
    val createdDate: LocalDateTime,
    val thumbnailFile: String?
)