package com.vicheGallery.auth.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/vicheGallery/auth/ui/AuthController;", "", "authService", "Lcom/vicheGallery/auth/application/AuthService;", "(Lcom/vicheGallery/auth/application/AuthService;)V", "getAuthService", "()Lcom/vicheGallery/auth/application/AuthService;", "login", "Lorg/springframework/http/ResponseEntity;", "Lcom/vicheGallery/auth/dto/TokenResponse;", "request", "Lcom/vicheGallery/auth/dto/TokenRequest;", "vicheGallery"})
@org.springframework.web.bind.annotation.RequestMapping(value = {"/auth"})
@org.springframework.web.bind.annotation.RestController()
public class AuthController {
    @org.jetbrains.annotations.NotNull()
    private final com.vicheGallery.auth.application.AuthService authService = null;
    
    public AuthController(@org.jetbrains.annotations.NotNull()
    @org.springframework.beans.factory.annotation.Autowired()
    com.vicheGallery.auth.application.AuthService authService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.vicheGallery.auth.application.AuthService getAuthService() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @org.springframework.web.bind.annotation.PostMapping(value = {"/login/token"})
    public org.springframework.http.ResponseEntity<com.vicheGallery.auth.dto.TokenResponse> login(@org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.RequestBody()
    com.vicheGallery.auth.dto.TokenRequest request) {
        return null;
    }
}