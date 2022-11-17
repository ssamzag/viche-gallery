package com.vicheGallery.comment.domain

import com.vicheGallery.BaseEntity
import io.lettuce.core.dynamic.annotation.CommandNaming.Strategy
import java.sql.Blob
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Comment(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val postId: Long,
    val content: String,
    val userId: Long?,
    var nickname: String?,
    val password: String?,
    val ip: String?
) : BaseEntity() {

}
