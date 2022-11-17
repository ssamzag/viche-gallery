package com.vicheGallery.comment.dto

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

data class CommentResponse(
    val id: Long?,
    val content: String,
    val nickname: String?,
    val isMember: Boolean,
    val createdDate: LocalDateTime,
    val modifiedDate: LocalDateTime
)

