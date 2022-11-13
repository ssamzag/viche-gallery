package com.vicheGallery.work.application

import com.vicheGallery.work.domain.Work
import com.vicheGallery.work.dto.WorkReadResponse
import com.vicheGallery.work.dto.WorkWriteRequest
import com.vicheGallery.work.dto.WorkWriteResponse
import com.vicheGallery.work.repository.WorkRepository
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class WorkService(
    val workRepository: WorkRepository
) {
    fun create(request: WorkWriteRequest): WorkWriteResponse {
        val work = Work(
            title = request.title,
            content = request.content
        )
        work.setAttachments(request.attachments)
        val persistWork = workRepository.save(work)

        return WorkWriteResponse(
            persistWork.id,
            persistWork.title,
            persistWork.content,
            persistWork.getStoredNames()
        )
    }

    fun read(id: Long): WorkReadResponse {
        val persistWork = workRepository.findById(id).get()
        return WorkReadResponse(
            persistWork.title,
            persistWork.content,
            persistWork.getStoredNames()
        )
    }

    fun findAll(): List<WorkReadResponse>? {
        return workRepository.findAll(Sort.by(Sort.Direction.DESC, "id"))
            .map {
                WorkReadResponse(it.title, it.content, it.getStoredNames())
            }
    }
}