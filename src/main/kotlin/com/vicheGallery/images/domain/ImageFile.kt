package com.vicheGallery.images.domain

import com.vicheGallery.BaseEntity
import com.vicheGallery.images.dto.UploadFile
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class ImageFile(
    var storeImageName: String,

    val uploadImageName: String,

    val uploadBy: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) : BaseEntity() {
    companion object {
        fun of(file: UploadFile?): ImageFile {
            return ImageFile(
                storeImageName = file!!.storeFileName,
                uploadImageName = file.uploadFileName!!,
                uploadBy = ""
            )
        }
    }
}