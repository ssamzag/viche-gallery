package com.vicheGallery.post.domain

import com.vicheGallery.BaseEntity
import com.vicheGallery.post.dto.PostResponse
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Lob

@Entity
data class Post (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val title: String,

    @Lob
    val content: String
) : BaseEntity() {
    fun toResponse(): PostResponse {
        return PostResponse(id, title, content)
    }
}