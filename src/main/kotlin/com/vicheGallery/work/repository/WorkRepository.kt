package com.vicheGallery.work.repository

import com.vicheGallery.work.domain.Work
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkRepository : JpaRepository<Work, Long> {
    fun findByWorkType(id: Long) : List<Work>
}