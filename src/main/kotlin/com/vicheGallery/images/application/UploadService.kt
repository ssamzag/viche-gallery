package com.vicheGallery.images.application

import com.vicheGallery.images.domain.FileStore
import com.vicheGallery.images.domain.ImageFile
import com.vicheGallery.images.domain.ImageFileRepository
import com.vicheGallery.images.domain.UploadFile
import com.vicheGallery.images.dto.UploadForm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.UrlResource
import org.springframework.stereotype.Service

@Service
class UploadService(
    @Autowired val imageFileRepository: ImageFileRepository,
    @Autowired private val fileStore: FileStore
) {
    fun save(uploadForm: UploadForm): List<UploadFile?> {
        val storeFiles: List<UploadFile?> = fileStore.storeFiles(uploadForm.multipartFiles)
        imageFileRepository.saveAll(toImageFileList(storeFiles))
        return storeFiles;
    }

    fun imageList(): List<ImageFile>{
        return imageFileRepository.findAll()
    }

    private fun toImageFileList(storeFiles: List<UploadFile?>): List<ImageFile> {
        return storeFiles.map { s ->
            ImageFile(
                storeImageName = s!!.storeFileName,
                uploadImageName = s.uploadFileName!!,
                uploadBy = "")
        }.toList()
    }

    fun downloadImage(filename: String): UrlResource {
        return UrlResource("file:" + fileStore.storeFullPath(filename))
    }

    fun downloadThumbnailImage(filename: String): UrlResource {
        if (!fileStore.mediumFileExists(filename)) {
            fileStore.storeMediumFile(filename)
        }

        return UrlResource("file:" + fileStore.mediumFullPath(filename))
    }
}