package com.vicheGallery;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0017J\u0018\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\bH\u0017\u00a8\u0006\t"}, d2 = {"Lcom/vicheGallery/ExceptionHandler;", "", "()V", "handleIllegalArgsException", "Lorg/springframework/http/ResponseEntity;", "e", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "Lorg/springframework/dao/DataIntegrityViolationException;", "vicheGallery"})
@org.springframework.web.bind.annotation.RestControllerAdvice()
public class ExceptionHandler {
    
    public ExceptionHandler() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {org.springframework.dao.DataIntegrityViolationException.class})
    public org.springframework.http.ResponseEntity<?> handleIllegalArgsException(@org.jetbrains.annotations.Nullable()
    org.springframework.dao.DataIntegrityViolationException e) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {java.lang.IllegalArgumentException.class})
    public org.springframework.http.ResponseEntity<?> handleIllegalArgsException(@org.jetbrains.annotations.NotNull()
    java.lang.IllegalArgumentException e) {
        return null;
    }
}