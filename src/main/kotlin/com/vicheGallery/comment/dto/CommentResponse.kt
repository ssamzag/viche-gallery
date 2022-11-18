package com.vicheGallery.comment.dto

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

data class CommentResponse(
    val id: Long?,
    val content: String,
    val nickname: String?,
    val isMember: Boolean,
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    val createdDate: LocalDateTime,
    val modifiedDate: LocalDateTime
)

