package com.vicheGallery.post.ui

import com.vicheGallery.auth.domain.AuthenticationPrincipal
import com.vicheGallery.auth.domain.LoginUser
import com.vicheGallery.post.dto.PostRequest
import com.vicheGallery.post.application.PostService
import com.vicheGallery.post.dto.PostRead
import com.vicheGallery.post.dto.PostsResponse
import com.vicheGallery.post.dto.UpdateRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/posts")
class PostController(
    @Autowired private val postService: PostService)
{
    @PostMapping
    fun createPost(
        @RequestBody @Valid request: PostRequest,
        @AuthenticationPrincipal user: LoginUser
    ): ResponseEntity<String> {
        val id = postService.write(request)
        return ResponseEntity.ok().body("/post/${id}")
    }

    @GetMapping
    fun getPosts(): ResponseEntity<PostsResponse> {
        return ResponseEntity.ok()
            .body(postService.findAllDesc())
    }

    @GetMapping("/{postId}")
    fun getPost(@PathVariable postId: Long): ResponseEntity<PostRead> {
        return ResponseEntity.ok()
            .body(postService.findByPostIdOrThrow(postId))
    }

    @PutMapping("/{postId}")
    fun update(@AuthenticationPrincipal user: LoginUser,
               @PathVariable postId: Long,
               @RequestBody req: UpdateRequest): ResponseEntity<Any> {
        postService.updatePost(postId, req)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{postId}")
    fun delete(@AuthenticationPrincipal user: LoginUser,
               @PathVariable postId: Long): ResponseEntity<Any> {
        postService.deletePost(postId)
        return ResponseEntity.noContent().build()
    }

}