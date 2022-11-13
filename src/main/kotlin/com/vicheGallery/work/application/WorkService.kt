package com.vicheGallery.work.service

import com.vicheGallery.work.domain.Work
import com.vicheGallery.work.dto.WriteRequest
import com.vicheGallery.work.repository.WorkRepository
import org.springframework.stereotype.Service

@Service
class WorkService(
    val workRepository: WorkRepository
) {
    fun save(request: WriteRequest): Work {
        return workRepository.save(
            Work(
                title = request.title,
                content = request.content,
                attachments = request.attachments
            )
        )
    }
}