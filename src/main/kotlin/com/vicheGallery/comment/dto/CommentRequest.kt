package com.vicheGallery.comment.dto

data class CommentRequest(
    val content: String,
    val nickname: String,
    val password: String
)
