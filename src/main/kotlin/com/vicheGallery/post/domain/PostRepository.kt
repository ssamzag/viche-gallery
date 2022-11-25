package com.vicheGallery.post.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : JpaRepository<Post, Long>
{
    override fun deleteById(id: Long)
}