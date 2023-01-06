package com.vicheGallery.post.application

import com.vicheGallery.post.domain.Post
import com.vicheGallery.post.repository.PostRepository
import com.vicheGallery.post.dto.*
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*
import kotlin.IllegalArgumentException

@Service
class PostService(
    private val postRepository: PostRepository
) {
    @Transactional
    fun write(postRequest: PostRequest): Long? {
        val post = postRepository.save(postRequest.toPost())
        return post.id
    }

    @Transactional
    fun findByPostIdOrThrow(postId: Long): PostRead {
        val post = postRepository.findByIdAndDeletedFalse(postId)
            ?: throw IllegalArgumentException("존재하지 않는 글입니다.")

        return PostRead(
            title = post.title,
            content = post.content,
            createdDate = post.createdDate,
            modifiedData = post.modifiedDate
        )
    }

    @Transactional
    fun findAllDesc(): PostsResponse {
        return PostsResponse(
            postRepository.findByDeletedFalse(Sort.by(Sort.Direction.DESC, "id"))
                .map (PostResponse::of))
    }

    @Transactional
    fun deletePost(postId: Long) {
        val post = postRepository.findById(postId)
        validate(post)
        post.get().delete()
    }

    @Transactional
    fun updatePost(postId: Long, req: UpdateRequest) {
        val post = postRepository.findById(postId)
        validate(post)
        post.get().update(req.title, req.content)
    }

    fun validate(post: Optional<Post>) {
        if (post.isEmpty || post.get().deleted!!) {
            throw IllegalArgumentException("삭제된 글입니다.")
        }
    }
}