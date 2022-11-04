package com.vicheGallery.images.application

import com.vicheGallery.images.domain.ImageFile
import com.vicheGallery.images.domain.ImageFileRepository
import com.vicheGallery.images.domain.UploadFile
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UploadService(
    @Autowired val imageFileRepository: ImageFileRepository
) {
    fun save(storeFiles: List<UploadFile?>): MutableList<ImageFile> {
        return imageFileRepository.saveAll(toImageFileList(storeFiles))
    }

    fun imageList(): List<ImageFile>{
        return imageFileRepository.findAll()
    }

    private fun toImageFileList(storeFiles: List<UploadFile?>): List<ImageFile> {
        return storeFiles.map { s ->
            ImageFile(storeImageName = s!!.storeFileName, uploadImageName = s.uploadFileName!!, uploadBy = "")
        }.toList()
    }
}