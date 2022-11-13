package com.vicheGallery.images.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0012J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0012J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/vicheGallery/images/domain/FileStore;", "", "fileDir", "", "(Ljava/lang/String;)V", "createStoreFileName", "originalFilename", "extractExt", "fullPath", "fileName", "storeFile", "Lcom/vicheGallery/images/domain/UploadFile;", "multipartFile", "Lorg/springframework/web/multipart/MultipartFile;", "storeFiles", "", "multipartFiles", "vicheGallery"})
@org.springframework.stereotype.Component()
public class FileStore {
    private final java.lang.String fileDir = null;
    
    public FileStore(@org.jetbrains.annotations.NotNull()
    @org.springframework.beans.factory.annotation.Value(value = "${imageFile.dir}")
    java.lang.String fileDir) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String fullPath(@org.jetbrains.annotations.NotNull()
    java.lang.String fileName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.vicheGallery.images.domain.UploadFile> storeFiles(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends org.springframework.web.multipart.MultipartFile> multipartFiles) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public com.vicheGallery.images.domain.UploadFile storeFile(@org.jetbrains.annotations.NotNull()
    org.springframework.web.multipart.MultipartFile multipartFile) {
        return null;
    }
    
    private java.lang.String createStoreFileName(java.lang.String originalFilename) {
        return null;
    }
    
    private java.lang.String extractExt(java.lang.String originalFilename) {
        return null;
    }
}