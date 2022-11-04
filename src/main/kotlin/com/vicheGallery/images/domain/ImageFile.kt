package com.vicheGallery.images.domain

import com.vicheGallery.BaseEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class ImageFile(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var storeImageName: String,
    val uploadImageName: String,
    val uploadBy: String
) : BaseEntity()