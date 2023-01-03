package com.vicheGallery.work.dto

import com.vicheGallery.work.domain.Work

data class WorkReadResponse(
    val workId: Long?,
    val title: String,
    val content: String,
    val attachments: List<String>?
) {
    companion object {
        fun of(work: Work): WorkReadResponse {
            return WorkReadResponse(
                workId = work.id,
                title = work.title,
                content = work.content,
                attachments = work.getStoredNames()
            )
        }
    }
}
