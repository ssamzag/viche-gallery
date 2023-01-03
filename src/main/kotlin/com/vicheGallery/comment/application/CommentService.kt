package com.vicheGallery.comment.application

import com.vicheGallery.util.RemoteAddr
import com.vicheGallery.auth.domain.encrypt.Password
import com.vicheGallery.comment.domain.Comment
import com.vicheGallery.comment.repository.CommentRepository
import com.vicheGallery.comment.repository.CommentQueryRepository
import com.vicheGallery.comment.dto.*
import com.vicheGallery.post.application.PostService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.servlet.http.HttpServletRequest
import kotlin.IllegalArgumentException

@Service
class CommentService(
    private val commentQueryRepository: CommentQueryRepository,
    private val commentRepository: CommentRepository,
    private val postService: PostService,
    private val password: Password
) {
    fun save(
        postId: Long,
        req: CommentRequest,
        httpServletRequest: HttpServletRequest
    ): Comment {
        validate(postId)
        return commentRepository.save(
            Comment(
                postId = postId,
                content = req.content,
                password = password.encrypt(req.password),
                nickname = req.nickname,
                ip = RemoteAddr().getClientIp(httpServletRequest)
            )
        )
    }

    fun saveReply(
        postId: Long,
        req: ReplyCommentRequest,
        httpServletRequest: HttpServletRequest
    ): Comment {
        validate(postId)
        val findById = commentRepository.findById(req.refCommentId).get()

        return commentRepository.save(
            Comment(
                postId = postId,
                refComment = findById,
                replyToNick = req.replyToNick,
                content = req.content,
                password = password.encrypt(req.password),
                nickname = req.nickname,
                ip = RemoteAddr().getClientIp(httpServletRequest)
            )
        )
    }

    @Transactional
    fun findByPostId(postId: Long): CommentsResponse? {
        val comments = commentQueryRepository.getComments(postId)
        return CommentsResponse.of(comments)
    }

    @Transactional
    fun delete(commentId: Long, password: String) {
        val comment = commentRepository.findById(commentId).get()
        validate(comment, password)
        comment.delete()
    }

    @Transactional
    fun update(commentId: Long, request: CommentUpdateRequest) {
        val comment = commentRepository.findById(commentId).get()
        validate(comment, request.password)
        comment.updateContent(request.content)
    }

    private fun validate(comment: Comment, password: String) {
        if (comment.password != this.password.encrypt(password)) {
            throw IllegalArgumentException("암호를 확인해 주세요.")
        }
        if (comment.deleted) {
            throw IllegalArgumentException("삭제된 댓글입니다.")
        }
    }

    private fun validate(postId: Long) {
        postService.findByPostIdOrThrow(postId)
    }
}
