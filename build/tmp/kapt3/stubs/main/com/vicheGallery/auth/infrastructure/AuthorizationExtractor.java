package com.vicheGallery.auth.infrastructure;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/vicheGallery/auth/infrastructure/AuthorizationExtractor;", "", "()V", "Companion", "vicheGallery"})
public final class AuthorizationExtractor {
    @org.jetbrains.annotations.NotNull()
    public static final com.vicheGallery.auth.infrastructure.AuthorizationExtractor.Companion Companion = null;
    private static final java.lang.String AUTHORIZATION = "Authorization";
    private static final java.lang.String BEARER_TYPE = "Bearer";
    private static final java.lang.String ACCESS_TOKEN_TYPE = null;
    
    public AuthorizationExtractor() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/vicheGallery/auth/infrastructure/AuthorizationExtractor$Companion;", "", "()V", "ACCESS_TOKEN_TYPE", "", "AUTHORIZATION", "BEARER_TYPE", "extract", "request", "Ljavax/servlet/http/HttpServletRequest;", "vicheGallery"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String extract(@org.jetbrains.annotations.NotNull()
        javax.servlet.http.HttpServletRequest request) {
            return null;
        }
    }
}