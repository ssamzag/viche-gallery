package com.vicheGallery.post.application

import com.vicheGallery.post.domain.Post
import com.vicheGallery.post.domain.PostRepository
import com.vicheGallery.post.dto.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
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
                .map {
                    PostResponse(it.id, it.title, it.content, it.createdDate, it.firstFile())
                })
    }

    @Transactional
    fun deletePost(postId: Long) {
        val post: Post = postRepository.findById(postId).get()
        validate(post)
        post.delete()
    }

    @Transactional
    fun updatePost(postId: Long, req: UpdateRequest) {
        val post: Post = postRepository.findById(postId).get()
        validate(post)
        post.update(req.title, req.content)
    }

    fun validate(post: Post) {
        if (post.deleted!!) {
            throw IllegalArgumentException("삭제된 글입니다.")
        }
    }
}