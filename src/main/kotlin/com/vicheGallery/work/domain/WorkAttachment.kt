package com.vicheGallery.work.domain

import javax.persistence.*

@Entity
class WorkAttachment(
    val storedName: String,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "work_id")
    val work: Work? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {
    companion object {
        fun of(name: String, work: Work) : WorkAttachment{
            return WorkAttachment(
                work = work,
                storedName = name
            )
        }
    }

}