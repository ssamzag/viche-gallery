package com.vicheGallery.work.domain

import org.springframework.beans.factory.annotation.Value
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
        }.toList()
    }
}