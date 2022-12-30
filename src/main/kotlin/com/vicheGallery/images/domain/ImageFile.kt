package com.vicheGallery.images.domain

import com.vicheGallery.BaseEntity
import com.vicheGallery.work.domain.Work
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class ImageFile(
    var storeImageName: String,

    val uploadImageName: String,

    val uploadBy: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) : BaseEntity()