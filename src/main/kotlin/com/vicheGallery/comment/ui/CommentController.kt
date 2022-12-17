package com.vicheGallery.comment.ui

import com.vicheGallery.comment.application.CommentService
import com.vicheGallery.comment.domain.CommentRepository
import com.vicheGallery.comment.dto.CommentRequest
import com.vicheGallery.comment.dto.CommentUpdateRequest
import com.vicheGallery.comment.dto.CommentsResponse
import com.vicheGallery.comment.dto.ReplyCommentRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid


@RestController
@RequestMapping("/comment")
class CommentController(
    @Autowired private val commentService: CommentService,
) {
    @PostMapping("/{postId}")
    fun write(
        @PathVariable postId: Long,
        @RequestBody @Valid req: CommentRequest,
        httpServletRequest: HttpServletRequest
    ) : ResponseEntity<String> {
        commentService.save(postId, req, httpServletRequest)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/reply/{postId}")
    fun writeReply(
        @PathVariable postId: Long,
        @RequestBody @Valid req: ReplyCommentRequest,
        httpServletRequest: HttpServletRequest
    ) : ResponseEntity<String> {
        commentService.saveReply(postId, req, httpServletRequest)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{postId}")
    fun read(@PathVariable postId: Long) : ResponseEntity<CommentsResponse> {
        return ResponseEntity.ok().body(commentService.findByPostId(postId))
    }

    @PutMapping("/{commentId}")
    fun update(
        @PathVariable commentId: Long,
        @RequestBody @Valid request: CommentUpdateRequest): ResponseEntity<Any> {
        commentService.update(commentId, request);
        return ResponseEntity.noContent().build()
    }
    @DeleteMapping("/{commentId}")
    fun delete(@PathVariable commentId: Long, @RequestParam password: String): ResponseEntity<Any> {
        commentService.delete(commentId, password);
        return ResponseEntity.noContent().build()
    }
}