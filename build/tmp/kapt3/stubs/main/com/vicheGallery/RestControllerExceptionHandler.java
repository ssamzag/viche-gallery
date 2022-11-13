package com.vicheGallery;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0012J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0017\u00a8\u0006\n"}, d2 = {"Lcom/vicheGallery/RestControllerExceptionHandler;", "", "()V", "getErrorList", "", "Lcom/vicheGallery/exceptionResponse/dto/Error;", "e", "Lorg/springframework/web/bind/MethodArgumentNotValidException;", "invalidRequestHandler", "Lcom/vicheGallery/exceptionResponse/dto/ErrorResponse;", "vicheGallery"})
@org.springframework.web.bind.annotation.RestControllerAdvice()
public class RestControllerExceptionHandler {
    
    public RestControllerExceptionHandler() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {java.lang.Exception.class})
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.BAD_REQUEST)
    public com.vicheGallery.exceptionResponse.dto.ErrorResponse invalidRequestHandler(@org.jetbrains.annotations.NotNull()
    org.springframework.web.bind.MethodArgumentNotValidException e) {
        return null;
    }
    
    private java.util.List<com.vicheGallery.exceptionResponse.dto.Error> getErrorList(org.springframework.web.bind.MethodArgumentNotValidException e) {
        return null;
    }
}