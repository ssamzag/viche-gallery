package com.vicheGallery.comment.application

import com.vicheGallery.RemoteAddr
import com.vicheGallery.auth.domain.encrypt.Password
import com.vicheGallery.comment.domain.Comment
import com.vicheGallery.comment.domain.CommentRepository
import com.vicheGallery.comment.dto.CommentRequest
import com.vicheGallery.comment.dto.CommentResponse
import com.vicheGallery.comment.dto.CommentsResponse
import com.vicheGallery.post.application.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import javax.servlet.http.HttpServletRequest

@Service
class CommentService(
    @Autowired val commentRepository: CommentRepository,
    @Autowired val postService: PostService,
    @Autowired val password: Password
) {

    fun save(
        postId: Long,
        req: CommentRequest,
        httpServletRequest: HttpServletRequest
    ): Comment {
        validate(postId)

        return commentRepository.save(
            Comment(
                id = null,
                postId = postId,
                userId = null,
                content = req.content,
                password = password.encrypt(req.password),
                nickname = req.nickname,
                ip = RemoteAddr().getClientIp(httpServletRequest)
            )
        )
    }

    fun findByPostId(postId: Long): CommentsResponse {
        val comments = commentRepository.findByPostId(postId)
        return CommentsResponse(comments.map {
            CommentResponse(
                id = it.id!!,
                content = it.content,
                isMember = it.userId != null,
                nickname = it.nickname,
                createdDate = it.createdDate,
                modifiedDate = it.modifiedDate
            )
        }.toList())
    }

    fun delete(commentId: Long, password: String) {
        val comment = commentRepository.findById(commentId).get()
        validate(comment, password)
        commentRepository.delete(comment)
    }

    private fun validate(findById: Comment, password: String) {
        if (findById.password != this.password.encrypt(password)) {
            throw IllegalArgumentException("암호가 틀렸습니다.")
        }
    }

    private fun validate(postId: Long) {
        postService.findByPostIdOrThrow(postId)
    }
}
