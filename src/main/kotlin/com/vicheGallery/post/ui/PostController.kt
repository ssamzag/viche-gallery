package com.vicheGallery.post.ui

import com.vicheGallery.post.dto.PostRequest
import com.vicheGallery.post.dto.PostResponse
import com.vicheGallery.post.application.PostService
import com.vicheGallery.post.dto.PostRead
import org.apache.coyote.Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping("/posts")
class PostController (val postService: PostService) {

    @PostMapping
    fun write(@RequestBody @Valid request: PostRequest): ResponseEntity<PostResponse> {
        val id = postService.write(request)
        return ResponseEntity.created(URI.create("/posts/${id}")).build()
    }

    @GetMapping("/{postId}")
    fun getPost(@PathVariable postId: Long) : ResponseEntity<PostRead> {
        return ResponseEntity.ok()
            .body(postService.findByPostId(postId))
    }
}