package com.vicheGallery.post.dto

import com.vicheGallery.post.domain.Post
import org.jetbrains.annotations.NotNull
import javax.validation.constraints.NotBlank


data class PostRequest(
    @field: NotBlank(message="타이틀을 입력하세요.")
    var title: String,
    @field: NotBlank(message = "내용을 입력하세요.")
    var content: String,
    val attachments: List<String>?
) {
    fun toPost(): Post {
        val post = Post(title = title, content = content)
        post.setAttachments(attachments)
        return post
    }
}