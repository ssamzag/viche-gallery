package com.vicheGallery.post.domain

import javax.persistence.CascadeType.ALL
import javax.persistence.Embeddable
import javax.persistence.FetchType.LAZY
import javax.persistence.OneToMany

@Embeddable
class PostAttachments(
    @OneToMany(mappedBy = "post", cascade = [ALL], orphanRemoval = true)
    val attachments: List<PostAttachment>? = null
) {
    fun firstFile(): String? {
        if (getFileUrl().isNotEmpty()) {
            return getFileUrl()[0]
        }
        return null
    }

    private fun getFileUrl(): List<String> {
        return attachments?.map {
            it.storedName
        }!!
    }

}