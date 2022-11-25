package com.vicheGallery.images.ui

import com.vicheGallery.auth.domain.AuthenticationPrincipal
import com.vicheGallery.auth.domain.LoginUser
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
    @Autowired private val uploadService: UploadService
) {
    @PostMapping("/upload")
    fun upload(
        @ModelAttribute uploadForm: UploadForm,
        @AuthenticationPrincipal loginUser: LoginUser
    ): ResponseEntity<List<UploadFile?>> {
        return ResponseEntity.ok().body(uploadService.save(uploadForm))
    }

    @GetMapping("/{filename}")
    fun downloadImage(@PathVariable filename: String): ResponseEntity<UrlResource> {
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
            .body(uploadService.downloadImage(filename))
    }

    @GetMapping("/thumbnail/{filename}")
    fun downloadThumbnailImage(@PathVariable filename: String): ResponseEntity<UrlResource> {
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
            .body(uploadService.downloadThumbnailImage(filename))
    }

    @GetMapping("/list")
    fun imageList(): List<ImageFile> {
        return uploadService.imageList()
    }

}