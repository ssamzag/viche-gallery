package com.vicheGallery.post.domain

import com.vicheGallery.BaseEntity
import javax.persistence.*

@Entity
class PostAttachment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val storedName: String,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "post_id")
    val post: Post? = null
) : BaseEntity()