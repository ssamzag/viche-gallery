package com.vicheGallery.work.application

import com.vicheGallery.work.domain.Work
import com.vicheGallery.work.domain.WorkType
import com.vicheGallery.work.dto.WorkReadResponse
import com.vicheGallery.work.dto.WorkWriteRequest
import com.vicheGallery.work.dto.WorkWriteResponse
import com.vicheGallery.work.repository.WorkRepository
import com.vicheGallery.work.repository.WorkRepositoryCustom
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class WorkService(
    private val workRepository: WorkRepository,
    private val workRepositoryCustom: WorkRepositoryCustom
) {
    @Transactional
    fun create(request: WorkWriteRequest): WorkWriteResponse {
        val work = Work(
            title = request.title,
            content = request.content,
            workType = request.workType
        )
        work.setAttachments(request.attachments)
        val persistWork = workRepository.save(work)

        return WorkWriteResponse(
            persistWork.id,
            persistWork.title,
            persistWork.content,
            persistWork.workType,
            persistWork.getStoredNames()
        )
    }

    fun read(id: Long): WorkReadResponse {
        val persistWork = workRepository.findById(id)
            .orElseThrow(::IllegalStateException)

        return WorkReadResponse(
            persistWork.id,
            persistWork.title,
            persistWork.content,
            persistWork.getStoredNames()
        )
    }

    fun findByWorkType(workType: WorkType): List<WorkReadResponse>? {
        return workRepositoryCustom.findByWorkType(workType)
            .map (WorkReadResponse::of)
    }

    @Transactional
    fun delete(id: Long) {
        val work = workRepository.findById(id).get()
        validate(work)
        work.delete()
    }

    private fun validate(persist: Work) {
        if (persist.deleted) {
            throw IllegalArgumentException("삭제할 수 없습니다.")
        }
    }
}