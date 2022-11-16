package com.vicheGallery.auth.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J.\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/vicheGallery/auth/ui/AuthenticationPrincipalArgumentResolver;", "Lorg/springframework/web/method/support/HandlerMethodArgumentResolver;", "authService", "Lcom/vicheGallery/auth/application/AuthService;", "(Lcom/vicheGallery/auth/application/AuthService;)V", "getAuthService", "()Lcom/vicheGallery/auth/application/AuthService;", "resolveArgument", "", "parameter", "Lorg/springframework/core/MethodParameter;", "mavContainer", "Lorg/springframework/web/method/support/ModelAndViewContainer;", "webRequest", "Lorg/springframework/web/context/request/NativeWebRequest;", "binderFactory", "Lorg/springframework/web/bind/support/WebDataBinderFactory;", "supportsParameter", "", "vicheGallery"})
public final class AuthenticationPrincipalArgumentResolver implements org.springframework.web.method.support.HandlerMethodArgumentResolver {
    @org.jetbrains.annotations.NotNull()
    private final com.vicheGallery.auth.application.AuthService authService = null;
    
    public AuthenticationPrincipalArgumentResolver(@org.jetbrains.annotations.NotNull()
    @org.springframework.beans.factory.annotation.Autowired()
    com.vicheGallery.auth.application.AuthService authService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.vicheGallery.auth.application.AuthService getAuthService() {
        return null;
    }
    
    @java.lang.Override()
    public boolean supportsParameter(@org.jetbrains.annotations.NotNull()
    org.springframework.core.MethodParameter parameter) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object resolveArgument(@org.jetbrains.annotations.NotNull()
    org.springframework.core.MethodParameter parameter, @org.jetbrains.annotations.Nullable()
    org.springframework.web.method.support.ModelAndViewContainer mavContainer, @org.jetbrains.annotations.NotNull()
    org.springframework.web.context.request.NativeWebRequest webRequest, @org.jetbrains.annotations.Nullable()
    org.springframework.web.bind.support.WebDataBinderFactory binderFactory) {
        return null;
    }
}