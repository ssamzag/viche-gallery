package com.vicheGallery.post.ui

import com.vicheGallery.post.dto.PostRequest
import com.vicheGallery.post.dto.PostResponse
import com.vicheGallery.post.application.PostService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/post")
class PostController (val postService: PostService) {

    @PostMapping
    fun createPost(@RequestBody request: PostRequest): ResponseEntity<PostResponse> {
        val id = postService.savePost(request)
        return ResponseEntity.created(URI.create("/post/${id}")).build()
    }
}