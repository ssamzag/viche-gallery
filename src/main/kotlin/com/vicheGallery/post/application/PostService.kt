package com.vicheGallery.post.application

import com.vicheGallery.post.domain.Post
import com.vicheGallery.post.dto.PostRequest
import com.vicheGallery.post.domain.PostRepository
import com.vicheGallery.post.dto.PostRead
import com.vicheGallery.post.dto.PostResponse
import com.vicheGallery.post.dto.PostsResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException

@Service
class PostService(
    @Autowired val postRepository: PostRepository
) {
    @Transactional(readOnly = false)
    fun write(postRequest: PostRequest): Long? {
        val post = postRepository.save(postRequest.toPost())
        return post.id
    }

    fun findByPostIdOrThrow(postId: Long): PostRead {
        val post = postRepository.findByIdOrNull(postId)
            ?: throw IllegalArgumentException("존재하지 않는 글입니다.")

        return PostRead(
            title = post.title,
            content = post.content,
            createdDate = post.createdDate,
            modifiedData = post.modifiedDate
        )
    }

    fun findAllDesc(): PostsResponse {
        return PostsResponse(
            postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"))
                .map {
                    PostResponse(it.id, it.title, it.content, it.createdDate, it.firstFile())
                })
    }

    @Transactional
    fun deletePost(postId: Long) {
        val post: Post = postRepository.findById(postId).get()
//            ?: throw IllegalArgumentException("존재하지 않는 글입니다.")

        postRepository.delete(post)
    }
}