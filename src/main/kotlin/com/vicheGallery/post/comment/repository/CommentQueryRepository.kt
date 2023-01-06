package com.vicheGallery.comment.repository

import com.querydsl.core.types.NullExpression
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import com.vicheGallery.comment.domain.Comment
import com.vicheGallery.comment.domain.QComment.comment
import com.vicheGallery.comment.dto.CommentResponse
import org.springframework.stereotype.Repository

@Repository
class CommentQueryRepository(
    private val jpaQueryFactory: JPAQueryFactory
) {
    fun getComments(postId: Long): List<Comment> {
        return jpaQueryFactory.selectFrom(comment)
            .leftJoin(comment.refComment)
            .fetchJoin()
            .where(comment.postId.eq(postId), comment.deleted.eq(false))
            .orderBy(
                comment.refComment.id.asc().nullsFirst(),
                comment.createdDate.asc()
            )
            .fetch()
    }
}