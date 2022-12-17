package com.vicheGallery.comment.dto

import com.vicheGallery.comment.domain.Comment
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

data class CommentResponse(
    val id: Long?,
    val content: String,
    val nickname: String?,
    val replyToNick: String? = null,
    val refComment: Comment? = null,
    val child: ArrayList<CommentResponse>? = ArrayList(),
    val isMember: Boolean,
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    val createdDate: LocalDateTime,
    val modifiedDate: LocalDateTime
)