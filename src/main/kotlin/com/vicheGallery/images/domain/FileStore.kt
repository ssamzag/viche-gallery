package com.vicheGallery.images.domain

import com.vicheGallery.images.dto.UploadFile
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.lang.IllegalArgumentException
import java.util.*

@Component
class FileStore(
    @Value("\${imageFile.dir.original}")
    private val storeFileDir: String,
    @Value("\${imageFile.dir.thumbnailMedium}")
    private val mediumFileDir: String,
    @Value("\${imageFile.dir.thumbnailSmall}")
    private val smallFileDir: String,
    private val resizeImage: ResizeImage
) {
    fun storeFullPath(fileName: String): String {
        return storeFileDir + fileName
    }

    fun mediumFullPath(fileName: String): String {
        return mediumFileDir + fileName
    }

    fun storeFiles(multipartFiles: List<MultipartFile>): List<UploadFile?> {
        return multipartFiles.map(::storeFile)
    }

    fun storeFile(multipartFile: MultipartFile): UploadFile? {
        if (multipartFile.isEmpty) {
            throw IllegalArgumentException("파일이 존재하지 않습니다.")
        }
        val originalFilename = multipartFile.originalFilename!!
        val storeFileName = createNewFileName(originalFilename)

        multipartFile.transferTo(File(storeFullPath(storeFileName)))

        return UploadFile(originalFilename, storeFileName)
    }

    fun storeMediumFile(storeFilename: String) {
        resizeImage.imageResize(
            storeFullPath(storeFilename),
            extractExt(storeFilename),
            mediumFullPath(storeFilename),
        )
    }

    private fun createNewFileName(originalFilename: String): String {
        return UUID.randomUUID()
            .toString()
            .substring(0, 7) + "." + extractExt(originalFilename)
    }

    private fun extractExt(originalFilename: String): String {
        val pos = originalFilename.lastIndexOf(".")
        return originalFilename.substring(pos + 1)
    }

    fun mediumFileExists(filename: String): Boolean {
        return File(mediumFullPath(filename)).exists()
    }

}