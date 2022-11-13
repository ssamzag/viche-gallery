package com.vicheGallery.images.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0017J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0017J \u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r0\b2\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/vicheGallery/images/ui/UploadController;", "", "fileStore", "Lcom/vicheGallery/images/domain/FileStore;", "uploadService", "Lcom/vicheGallery/images/application/UploadService;", "(Lcom/vicheGallery/images/domain/FileStore;Lcom/vicheGallery/images/application/UploadService;)V", "downloadImage", "Lorg/springframework/http/ResponseEntity;", "Lorg/springframework/core/io/UrlResource;", "filename", "", "imageList", "", "Lcom/vicheGallery/images/domain/ImageFile;", "upload", "Lcom/vicheGallery/images/domain/UploadFile;", "uploadForm", "Lcom/vicheGallery/images/dto/UploadForm;", "vicheGallery"})
@org.springframework.web.bind.annotation.RequestMapping(value = {"/images"})
@org.springframework.web.bind.annotation.RestController()
public class UploadController {
    private final com.vicheGallery.images.domain.FileStore fileStore = null;
    private final com.vicheGallery.images.application.UploadService uploadService = null;
    
    public UploadController(@org.jetbrains.annotations.NotNull()
    @org.springframework.beans.factory.annotation.Autowired()
    com.vicheGallery.images.domain.FileStore fileStore, @org.jetbrains.annotations.NotNull()
    @org.springframework.beans.factory.annotation.Autowired()
    com.vicheGallery.images.application.UploadService uploadService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.PostMapping(value = {"/upload"})
    public org.springframework.http.ResponseEntity<java.util.List<com.vicheGallery.images.domain.UploadFile>> upload(@org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.ModelAttribute()
    com.vicheGallery.images.dto.UploadForm uploadForm) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.GetMapping(value = {"/{filename}"})
    public org.springframework.http.ResponseEntity<org.springframework.core.io.UrlResource> downloadImage(@org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.PathVariable()
    java.lang.String filename) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.GetMapping(value = {"/list"})
    public java.util.List<com.vicheGallery.images.domain.ImageFile> imageList() {
        return null;
    }
}