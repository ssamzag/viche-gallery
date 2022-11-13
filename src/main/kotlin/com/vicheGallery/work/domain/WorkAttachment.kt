package com.vicheGallery.work.domain

import javax.persistence.*

@Entity
class WorkAttachment(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val storedName: String,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "work_id")
    val work: Work? = null
)