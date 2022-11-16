package com.vicheGallery.post.domain

import javax.persistence.CascadeType
import javax.persistence.Embeddable
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Embeddable
class PostAttachments(
    @OneToMany(mappedBy = "post", cascade = [CascadeType.ALL], orphanRemoval = true)
    val attachments: List<PostAttachment>? = null
) {
    fun getFileUrl(): List<String> {
        return attachments?.map {
            it.storedName
        }!!.toList()
    }

    fun firstFile(): String? {
        if (getFileUrl().isNotEmpty()) {
            return getFileUrl()[0]
        }
        return null
    }
}