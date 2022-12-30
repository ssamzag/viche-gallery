package com.vicheGallery.comment.domain

import com.vicheGallery.BaseEntity
import org.jetbrains.annotations.NotNull
import org.springframework.objenesis.instantiator.basic.DelegatingToExoticInstantiator
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class Comment(
    @Column(nullable = false)
    var deleted: Boolean = false,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_comment_id")
    val refComment: Comment? = null,

    val replyToNick: String? = null,

    val postId: Long,

    @Lob
    @NotNull
    @Column(nullable = false)
    var content: String,

    val userId: Long? = null,

    @Column(length = 10, nullable = false)
    @NotNull
    var nickname: String?,

    @Column(length = 256, nullable = false)
    val password: String?,

    val ip: String?,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

) : BaseEntity() {
    fun updateContent(content: String) {
        this.content = content
    }

    fun delete() {
        this.deleted = true
    }
}
