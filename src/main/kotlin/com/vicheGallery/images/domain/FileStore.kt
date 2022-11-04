package com.vicheGallery.images.domain

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.util.*

@Component
class FileStore(
    @Value("\${file.dir}")
    private val fileDir: String
) {
    fun fullPath(fileName: String): String {
        return fileDir + fileName
    }

    fun storeFiles(multipartFiles: List<MultipartFile>): List<UploadFile?> {
        return multipartFiles.map(::storeFile).toList()
    }

    fun storeFile(multipartFile: MultipartFile): UploadFile? {
        if (multipartFile.isEmpty) {
            return null
        }

        val originalFilename = multipartFile.originalFilename
        val storeFileName = createStoreFileName(originalFilename)

        multipartFile.transferTo(File(fullPath(storeFileName)))

        return UploadFile(originalFilename, storeFileName)
    }

    private fun createStoreFileName(originalFilename: String?): String {
        return UUID.randomUUID()
            .toString()
            .substring(0, 7) + "." + extractExt(originalFilename)
    }

    private fun extractExt(originalFilename: String?): String? {
        val pos = originalFilename?.lastIndexOf(".")
        return originalFilename?.substring(pos!! + 1)
    }
}