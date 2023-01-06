package com.vicheGallery.post.comment.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CommentRequest(
    @field:NotBlank(message = "내용을 입력해 주세요.")
    val content: String,
    @field:NotBlank(message = "닉네임을 입력해 주세요.")
    @field:Size(max = 10, message = "닉네임은 10자 이하로만 가능합니다.")
    val nickname: String,
    @field:NotBlank(message = "암호를 입력해 주세요.")
    val password: String
)
