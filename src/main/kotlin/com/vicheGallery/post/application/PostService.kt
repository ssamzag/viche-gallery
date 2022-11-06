package com.vicheGallery.post.application

import com.vicheGallery.post.dto.PostRequest
import com.vicheGallery.post.domain.PostRepository
import com.vicheGallery.post.dto.PostRead
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException

@Service
@Transactional(readOnly = true)
class PostService(val postRepository: PostRepository) {
    fun write(postRequest: PostRequest): Long? {
        val post = postRepository.save(postRequest.toPost())
        return post.id
    }

    fun findByPostId(postId: Long): PostRead {
        val post = postRepository.findByIdOrNull(postId)
            ?: throw IllegalArgumentException("존재하지 않는 글입니다.")

        return PostRead(
            title = post.title,
            content = post.content,
            createdDate = post.createdDate,
            modifiedData = post.modifiedDate
        )

    }
}