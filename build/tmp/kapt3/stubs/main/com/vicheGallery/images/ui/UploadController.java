package com.vicheGallery.images.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0017J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0017J*\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b0\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/vicheGallery/images/ui/UploadController;", "", "uploadService", "Lcom/vicheGallery/images/application/UploadService;", "(Lcom/vicheGallery/images/application/UploadService;)V", "downloadImage", "Lorg/springframework/http/ResponseEntity;", "Lorg/springframework/core/io/UrlResource;", "filename", "", "imageList", "", "Lcom/vicheGallery/images/domain/ImageFile;", "upload", "Lcom/vicheGallery/images/domain/UploadFile;", "uploadForm", "Lcom/vicheGallery/images/dto/UploadForm;", "loginUser", "Lcom/vicheGallery/auth/domain/LoginUser;", "vicheGallery"})
@org.springframework.web.bind.annotation.RequestMapping(value = {"/images"})
@org.springframework.web.bind.annotation.RestController()
public class UploadController {
    private final com.vicheGallery.images.application.UploadService uploadService = null;
    
    public UploadController(@org.jetbrains.annotations.NotNull()
    @org.springframework.beans.factory.annotation.Autowired()
    com.vicheGallery.images.application.UploadService uploadService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.PostMapping(value = {"/upload"})
    public org.springframework.http.ResponseEntity<java.util.List<com.vicheGallery.images.domain.UploadFile>> upload(@org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.ModelAttribute()
    com.vicheGallery.images.dto.UploadForm uploadForm, @org.jetbrains.annotations.NotNull()
    @com.vicheGallery.auth.domain.AuthenticationPrincipal()
    com.vicheGallery.auth.domain.LoginUser loginUser) {
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