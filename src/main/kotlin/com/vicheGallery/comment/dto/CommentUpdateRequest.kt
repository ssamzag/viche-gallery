package com.vicheGallery.comment.dto

import javax.validation.constraints.NotBlank

data class CommentUpdateRequest(
    @field:NotBlank(message = "내용을 입력해 주세요.")
    val content: String,
    @field:NotBlank(message = "암호를 입력해 주세요.")
    val password: String
)
