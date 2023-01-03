package com.vicheGallery.work.domain

import javax.persistence.CascadeType
import javax.persistence.Embeddable
import javax.persistence.OneToMany

@Embeddable
class WorkAttachments(
    @OneToMany(mappedBy = "work", cascade = [CascadeType.ALL], orphanRemoval = true)
    val workAttachments: List<WorkAttachment>,
) {
    fun getFileUrl() : List<String> {
        return workAttachments.map {
            it.storedName
        }
    }

    companion object {
        fun of(attachments: List<String>, work: Work): WorkAttachments {
            return WorkAttachments(
                attachments.map { WorkAttachment.of(it, work) }
            )
        }
    }
}