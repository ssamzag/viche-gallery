package com.vicheGallery.post.domain

import com.vicheGallery.BaseEntity
import javax.persistence.*

@Entity
class PostAttachment(
    val storedName: String,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "post_id")
    var post: Post? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) : BaseEntity() {
    companion object {
        fun of(name: String, post: Post): PostAttachment {
            return PostAttachment(
                storedName = name,
                post = post
            )
        }
    }

}