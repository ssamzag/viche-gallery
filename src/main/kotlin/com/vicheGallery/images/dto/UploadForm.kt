package com.vicheGallery.images.dto

import org.springframework.web.multipart.MultipartFile

class UploadForm(
    val multipartFiles: List<MultipartFile>
)