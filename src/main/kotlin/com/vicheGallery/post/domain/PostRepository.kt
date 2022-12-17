package com.vicheGallery.post.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.data.domain.Sort

@Repository
interface PostRepository : JpaRepository<Post, Long>
{
    override fun deleteById(id: Long)
    fun findByIdAndDeletedFalse(id: Long) : Post?

    fun findByDeletedFalse(sort: Sort) : List<Post>
}