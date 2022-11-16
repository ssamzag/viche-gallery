package com.vicheGallery.auth.infrastructure;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/vicheGallery/auth/infrastructure/JwtTokenProvider;", "", "secretKey", "", "validityInMilliseconds", "", "(Ljava/lang/String;J)V", "createToken", "payload", "getPayload", "token", "validateToken", "", "vicheGallery"})
@org.springframework.stereotype.Component()
public class JwtTokenProvider {
    private final java.lang.String secretKey = null;
    private final long validityInMilliseconds = 0L;
    
    public JwtTokenProvider() {
        super();
    }
    
    public JwtTokenProvider(@org.jetbrains.annotations.Nullable()
    @org.springframework.beans.factory.annotation.Value(value = "${security.jwt.token.secret-key}")
    java.lang.String secretKey, @org.springframework.beans.factory.annotation.Value(value = "${security.jwt.token.expire-length}")
    long validityInMilliseconds) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String createToken(@org.jetbrains.annotations.Nullable()
    java.lang.String payload) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getPayload(@org.jetbrains.annotations.Nullable()
    java.lang.String token) {
        return null;
    }
    
    public boolean validateToken(@org.jetbrains.annotations.Nullable()
    java.lang.String token) {
        return false;
    }
}