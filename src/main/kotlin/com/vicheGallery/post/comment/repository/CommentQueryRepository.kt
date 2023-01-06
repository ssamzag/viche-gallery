package com.vicheGallery.post.comment.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.vicheGallery.post.comment.domain.Comment
import com.vicheGallery.post.comment.domain.QComment.comment
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