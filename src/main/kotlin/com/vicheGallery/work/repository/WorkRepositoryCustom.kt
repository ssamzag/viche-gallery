package com.vicheGallery.work.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.vicheGallery.work.domain.QWork.work
import com.vicheGallery.work.domain.Work
import com.vicheGallery.work.domain.WorkType
import org.springframework.stereotype.Repository

@Repository
class WorkRepositoryCustom (
    private val jpaQueryFactory: JPAQueryFactory
) {
    fun findByWorkType(workType: WorkType): List<Work> {
        return jpaQueryFactory.selectFrom(work)
            .where(
                work.workType.eq(workType)
                    .and(work.deleted.isFalse)
            )
            .orderBy(
                work.id.desc()
            )
            .fetch()
    }
}