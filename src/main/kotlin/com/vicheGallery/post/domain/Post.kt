package com.vicheGallery.post.domain

import com.vicheGallery.BaseEntity
import com.vicheGallery.images.domain.UploadFile
import com.vicheGallery.post.dto.PostResponse
import com.vicheGallery.work.domain.WorkAttachment
import com.vicheGallery.work.domain.WorkAttachments
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Lob

@Entity
class Post (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val title: String,

    @Lob
    val content: String,

    @Embedded
    var attachments: PostAttachments? = null
) : BaseEntity() {
    fun setAttachments(attachments: List<String>?) {
        if (attachments.isNullOrEmpty()) {
            return
        }

        this.attachments = PostAttachments(
            attachments.map { m ->
                PostAttachment(post = this, storedName = m)
            }.toList()
        )
    }
    fun firstFile(): String? {
        return attachments?.firstFile()
    }

}