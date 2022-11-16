package com.vicheGallery.work.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0017J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0017J\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\b\b\u0001\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/vicheGallery/work/ui/WorkController;", "", "workService", "Lcom/vicheGallery/work/application/WorkService;", "(Lcom/vicheGallery/work/application/WorkService;)V", "getWorkService", "()Lcom/vicheGallery/work/application/WorkService;", "findAll", "Lorg/springframework/http/ResponseEntity;", "", "Lcom/vicheGallery/work/dto/WorkReadResponse;", "read", "id", "", "write", "Lcom/vicheGallery/work/dto/WorkWriteResponse;", "workWriteRequest", "Lcom/vicheGallery/work/dto/WorkWriteRequest;", "loginUser", "Lcom/vicheGallery/auth/domain/LoginUser;", "vicheGallery"})
@org.springframework.web.bind.annotation.RestController()
@org.springframework.web.bind.annotation.RequestMapping(value = {"/works"})
public class WorkController {
    @org.jetbrains.annotations.NotNull()
    private final com.vicheGallery.work.application.WorkService workService = null;
    
    public WorkController(@org.jetbrains.annotations.NotNull()
    com.vicheGallery.work.application.WorkService workService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.vicheGallery.work.application.WorkService getWorkService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.PostMapping()
    public org.springframework.http.ResponseEntity<com.vicheGallery.work.dto.WorkWriteResponse> write(@org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.RequestBody()
    com.vicheGallery.work.dto.WorkWriteRequest workWriteRequest, @org.jetbrains.annotations.NotNull()
    @com.vicheGallery.auth.domain.AuthenticationPrincipal()
    com.vicheGallery.auth.domain.LoginUser loginUser) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.GetMapping()
    public org.springframework.http.ResponseEntity<java.util.List<com.vicheGallery.work.dto.WorkReadResponse>> findAll() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.GetMapping(value = {"/{id}"})
    public org.springframework.http.ResponseEntity<com.vicheGallery.work.dto.WorkReadResponse> read(@org.springframework.web.bind.annotation.PathVariable()
    long id) {
        return null;
    }
}