package com.vicheGallery.work.domain

import com.vicheGallery.work.dto.WorkWriteRequest
import javax.persistence.*

@Entity
class Work(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val title: String,

    val content: String,

    @Enumerated(EnumType.STRING)
    val workType: WorkType = WorkType.WORK,

    @Column(nullable = false)
    var deleted: Boolean = false,

    @Embedded
    var attachments: WorkAttachments? = null
) {
    fun setAttachments(attachments: List<String>?) {
        if (attachments.isNullOrEmpty()) {
            return
        }

        this.attachments = WorkAttachments(
            attachments.map { m ->
                WorkAttachment(
                    work = this,
                    storedName = m
                )
            }.toList()
        )
    }

    fun getStoredNames() : List<String>? {
        return attachments?.getFileUrl()
    }

    fun delete() {
        this.deleted = true
    }

    fun toWork(workWriteRequest: WorkWriteRequest): Work {
        return Work(
            title = workWriteRequest.title,
            content = workWriteRequest.content
        )
    }
}