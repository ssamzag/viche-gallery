package com.vicheGallery.images.ui

import com.vicheGallery.images.application.UploadService
import com.vicheGallery.images.domain.FileStore
import com.vicheGallery.images.domain.ImageFile
import com.vicheGallery.images.domain.UploadFile
import com.vicheGallery.images.dto.UploadForm
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.UrlResource
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.util.annotation.Nullable

@RestController
@RequestMapping("/images")
class UploadController(
    @Autowired private val fileStore: FileStore,
    @Autowired private val uploadService: UploadService
) {

    @PostMapping("/upload")
    fun upload(@ModelAttribute uploadForm: UploadForm): ResponseEntity<List<UploadFile?>> {
        var storeFiles: List<UploadFile?>

        return try {
            storeFiles = fileStore.storeFiles(uploadForm.multipartFiles)
            uploadService.save(storeFiles);
            ResponseEntity.ok().body(storeFiles)
        } catch (e: FileSizeLimitExceededException) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null)
        }
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