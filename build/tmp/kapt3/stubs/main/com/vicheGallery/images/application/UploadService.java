package com.vicheGallery.images.application;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\bH\u0016J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\bH\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/vicheGallery/images/application/UploadService;", "", "imageFileRepository", "Lcom/vicheGallery/images/domain/ImageFileRepository;", "(Lcom/vicheGallery/images/domain/ImageFileRepository;)V", "getImageFileRepository", "()Lcom/vicheGallery/images/domain/ImageFileRepository;", "imageList", "", "Lcom/vicheGallery/images/domain/ImageFile;", "save", "", "storeFiles", "Lcom/vicheGallery/images/domain/UploadFile;", "toImageFileList", "vicheGallery"})
@org.springframework.stereotype.Service()
public class UploadService {
    @org.jetbrains.annotations.NotNull()
    private final com.vicheGallery.images.domain.ImageFileRepository imageFileRepository = null;
    
    public UploadService(@org.jetbrains.annotations.NotNull()
    @org.springframework.beans.factory.annotation.Autowired()
    com.vicheGallery.images.domain.ImageFileRepository imageFileRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.vicheGallery.images.domain.ImageFileRepository getImageFileRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.vicheGallery.images.domain.ImageFile> save(@org.jetbrains.annotations.NotNull()
    java.util.List<com.vicheGallery.images.domain.UploadFile> storeFiles) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.vicheGallery.images.domain.ImageFile> imageList() {
        return null;
    }
    
    private java.util.List<com.vicheGallery.images.domain.ImageFile> toImageFileList(java.util.List<com.vicheGallery.images.domain.UploadFile> storeFiles) {
        return null;
    }
}