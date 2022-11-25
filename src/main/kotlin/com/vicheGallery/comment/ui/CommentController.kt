package com.vicheGallery.comment.ui

import com.vicheGallery.comment.application.CommentService
import com.vicheGallery.comment.domain.CommentRepository
import com.vicheGallery.comment.dto.CommentRequest
import com.vicheGallery.comment.dto.CommentsResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest


@RestController
@RequestMapping("/comment")
class CommentController(
    @Autowired
    val CommentService: CommentService,
) {
    @PostMapping("/{postId}")
    fun write(
        @PathVariable postId: Long,
        @RequestBody req: CommentRequest,
        httpServletRequest: HttpServletRequest
    ) : ResponseEntity<String> {
        CommentService.save(postId, req, httpServletRequest)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{postId}")
    fun read(@PathVariable postId: Long) : ResponseEntity<CommentsResponse> {
        return ResponseEntity.ok().body(CommentService.findByPostId(postId))
    }

    @DeleteMapping("/{commentId}")
    fun delete(@PathVariable commentId: Long, @RequestParam password: String): ResponseEntity<Any> {
        CommentService.delete(commentId, password);
        return ResponseEntity.noContent().build()
    }
}