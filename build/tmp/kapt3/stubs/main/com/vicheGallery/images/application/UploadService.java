package com.vicheGallery.images.application;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000eH\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/vicheGallery/images/application/UploadService;", "", "imageFileRepository", "Lcom/vicheGallery/images/domain/ImageFileRepository;", "fileStore", "Lcom/vicheGallery/images/domain/FileStore;", "(Lcom/vicheGallery/images/domain/ImageFileRepository;Lcom/vicheGallery/images/domain/FileStore;)V", "getImageFileRepository", "()Lcom/vicheGallery/images/domain/ImageFileRepository;", "downloadImage", "Lorg/springframework/core/io/UrlResource;", "filename", "", "imageList", "", "Lcom/vicheGallery/images/domain/ImageFile;", "save", "Lcom/vicheGallery/images/domain/UploadFile;", "uploadForm", "Lcom/vicheGallery/images/dto/UploadForm;", "toImageFileList", "storeFiles", "vicheGallery"})
@org.springframework.stereotype.Service()
public class UploadService {
    @org.jetbrains.annotations.NotNull()
    private final com.vicheGallery.images.domain.ImageFileRepository imageFileRepository = null;
    private final com.vicheGallery.images.domain.FileStore fileStore = null;
    
    public UploadService(@org.jetbrains.annotations.NotNull()
    @org.springframework.beans.factory.annotation.Autowired()
    com.vicheGallery.images.domain.ImageFileRepository imageFileRepository, @org.jetbrains.annotations.NotNull()
    @org.springframework.beans.factory.annotation.Autowired()
    com.vicheGallery.images.domain.FileStore fileStore) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.vicheGallery.images.domain.ImageFileRepository getImageFileRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.vicheGallery.images.domain.UploadFile> save(@org.jetbrains.annotations.NotNull()
    com.vicheGallery.images.dto.UploadForm uploadForm) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.vicheGallery.images.domain.ImageFile> imageList() {
        return null;
    }
    
    private java.util.List<com.vicheGallery.images.domain.ImageFile> toImageFileList(java.util.List<com.vicheGallery.images.domain.UploadFile> storeFiles) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.springframework.core.io.UrlResource downloadImage(@org.jetbrains.annotations.NotNull()
    java.lang.String filename) {
        return null;
    }
}