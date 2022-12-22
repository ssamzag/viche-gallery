package com.vicheGallery.work.dto

import com.vicheGallery.work.domain.WorkType

data class WorkWriteRequest(
    val title: String,
    val content: String,
    val workType: WorkType,
    val attachments: List<String>?
)