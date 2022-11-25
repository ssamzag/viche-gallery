package com.vicheGallery.comment.domain

import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long> {
    fun findByPostId(postId: Long): List<Comment>
    fun deleteByIdAndPassword(commentId: Long, password: String?)
}
