package com.vicheGallery.comment.domain

import com.querydsl.jpa.impl.JPAQueryFactory
import com.vicheGallery.comment.domain.QComment.comment
import org.springframework.stereotype.Repository

@Repository
class CommentRepositoryImpl (
    private val jpaQueryFactory: JPAQueryFactory
) {
    fun getComments(postId: Long): List<Comment> {
        return jpaQueryFactory.selectFrom(comment)
            .leftJoin(comment.refComment)
            .fetchJoin()
            .where(comment.postId.eq(postId))
            .orderBy(
                comment.refComment.id.asc().nullsFirst(),
                comment.createdDate.asc())
            .fetch()
    }
}