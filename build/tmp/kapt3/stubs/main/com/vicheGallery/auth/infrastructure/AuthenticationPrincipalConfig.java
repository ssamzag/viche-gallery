package com.vicheGallery.auth.infrastructure;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/vicheGallery/auth/infrastructure/AuthenticationPrincipalConfig;", "Lorg/springframework/web/servlet/config/annotation/WebMvcConfigurer;", "authService", "Lcom/vicheGallery/auth/application/AuthService;", "(Lcom/vicheGallery/auth/application/AuthService;)V", "getAuthService", "()Lcom/vicheGallery/auth/application/AuthService;", "addArgumentResolvers", "", "argumentResolvers", "", "Lorg/springframework/web/method/support/HandlerMethodArgumentResolver;", "createAuthenticationPrincipalArgumentResolver", "Lcom/vicheGallery/auth/ui/AuthenticationPrincipalArgumentResolver;", "vicheGallery"})
@org.springframework.context.annotation.Configuration()
public class AuthenticationPrincipalConfig implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {
    @org.jetbrains.annotations.NotNull()
    private final com.vicheGallery.auth.application.AuthService authService = null;
    
    public AuthenticationPrincipalConfig(@org.jetbrains.annotations.NotNull()
    @org.springframework.beans.factory.annotation.Autowired()
    com.vicheGallery.auth.application.AuthService authService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.vicheGallery.auth.application.AuthService getAuthService() {
        return null;
    }
    
    @java.lang.Override()
    public void addArgumentResolvers(@org.jetbrains.annotations.NotNull()
    java.util.List<org.springframework.web.method.support.HandlerMethodArgumentResolver> argumentResolvers) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.context.annotation.Bean()
    public com.vicheGallery.auth.ui.AuthenticationPrincipalArgumentResolver createAuthenticationPrincipalArgumentResolver() {
        return null;
    }
}