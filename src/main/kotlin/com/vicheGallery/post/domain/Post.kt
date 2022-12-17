package com.vicheGallery.post.domain

import com.vicheGallery.BaseEntity
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Post (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:Column(nullable = false)
    var deleted: Boolean? = false,

    var title: String,

    @Lob
    var content: String,

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

    fun delete() {
        this.deleted = true
    }

    fun update(title: String, content: String) {
        this.title = title
        this.content = content
        this.modifiedDate = LocalDateTime.now()
    }

}