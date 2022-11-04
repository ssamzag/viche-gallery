package com.vicheGallery.images.controller

import com.vicheGallery.images.application.UploadService
import com.vicheGallery.images.domain.FileStore
import com.vicheGallery.images.domain.ImageFile
import com.vicheGallery.images.domain.UploadFile
import com.vicheGallery.images.dto.UploadForm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.UrlResource
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/images")
class UploadController(
    @Autowired private val fileStore: FileStore,
    @Autowired private val uploadService: UploadService
) {

    @PostMapping("/upload")
    fun upload(@ModelAttribute uploadForm: UploadForm): List<UploadFile?> {
        val storeFiles = fileStore.storeFiles(uploadForm.multipartFiles)
        uploadService.save(storeFiles);

        return storeFiles
    }

    @GetMapping("/{filename}")
    fun downloadImage(@PathVariable filename: String): ResponseEntity<UrlResource> {
        val urlResource = UrlResource("file:" + fileStore.fullPath(filename))
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
            .body(urlResource)
    }

    @GetMapping("/list")
    fun imageList(): List<ImageFile> {
        return uploadService.imageList()
    }

}