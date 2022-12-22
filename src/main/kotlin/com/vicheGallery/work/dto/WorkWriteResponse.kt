package com.vicheGallery.work.dto

import com.vicheGallery.work.domain.WorkType

data class WorkWriteResponse(
    val id: Long?,
    val title: String,
    val content: String,
    val workType: WorkType,
    val attachments: List<String>?
)
