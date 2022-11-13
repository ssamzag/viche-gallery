package com.vicheGallery.work.dto

import com.vicheGallery.work.domain.WorkAttachments

class WriteRequest(
    val title: String,
    val content: String,
    val attachments: WorkAttachments?
)