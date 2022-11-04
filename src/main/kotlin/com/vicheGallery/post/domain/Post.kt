package com.vicheGallery.post.domain

import com.vicheGallery.post.dto.PostResponse
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Post(
    @Id @GeneratedValue
    val id: Long? = null,
    val title: String,
    val contents: String
) {
    fun toResponse(): PostResponse {
        return PostResponse(id, title, contents)
    }
}
