package com.vicheGallery.post.dto

import com.vicheGallery.post.domain.Post
import java.time.LocalDateTime

data class PostResponse(
    val id: Long?,
    val title: String,
    val content: String,
    val createdDate: LocalDateTime,
    val thumbnailFile: String?
) {
    companion object {
        fun of(post: Post): PostResponse {
            return PostResponse(
                id = post.id,
                title = post.title,
                content = post.content,
                createdDate = post.createdDate,
                thumbnailFile = post.firstFile()
            )
        }
    }
}