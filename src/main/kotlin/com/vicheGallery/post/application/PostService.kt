package com.vicheGallery.post.application

import com.vicheGallery.post.dto.PostRequest
import com.vicheGallery.post.domain.PostRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class PostService(val postRepository: PostRepository) {
    fun savePost(postRequest: PostRequest): Long? {
        val post = postRepository.save(postRequest.toPost())
        return post.id
    }
}