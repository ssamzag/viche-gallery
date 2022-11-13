package com.vicheGallery.work.dto

import com.vicheGallery.work.domain.WorkAttachments

data class WorkWriteResponse(
    val id: Long?,
    val title: String,
    val content: String,
    val attachments: List<String>?
)
