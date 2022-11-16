package com.vicheGallery.auth.application;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/vicheGallery/auth/application/AuthService;", "", "memberRepository", "Lcom/vicheGallery/member/domain/MemberRepository;", "jwtTokenProvider", "Lcom/vicheGallery/auth/infrastructure/JwtTokenProvider;", "(Lcom/vicheGallery/member/domain/MemberRepository;Lcom/vicheGallery/auth/infrastructure/JwtTokenProvider;)V", "getJwtTokenProvider", "()Lcom/vicheGallery/auth/infrastructure/JwtTokenProvider;", "getMemberRepository", "()Lcom/vicheGallery/member/domain/MemberRepository;", "findMemberByToken", "Lcom/vicheGallery/auth/domain/LoginUser;", "credentials", "", "login", "Lcom/vicheGallery/auth/dto/TokenResponse;", "request", "Lcom/vicheGallery/auth/dto/TokenRequest;", "vicheGallery"})
@org.springframework.stereotype.Service()
public class AuthService {
    @org.jetbrains.annotations.NotNull()
    private final com.vicheGallery.member.domain.MemberRepository memberRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.vicheGallery.auth.infrastructure.JwtTokenProvider jwtTokenProvider = null;
    
    public AuthService(@org.jetbrains.annotations.NotNull()
    @org.springframework.beans.factory.annotation.Autowired()
    com.vicheGallery.member.domain.MemberRepository memberRepository, @org.jetbrains.annotations.NotNull()
    @org.springframework.beans.factory.annotation.Autowired()
    com.vicheGallery.auth.infrastructure.JwtTokenProvider jwtTokenProvider) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.vicheGallery.member.domain.MemberRepository getMemberRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.vicheGallery.auth.infrastructure.JwtTokenProvider getJwtTokenProvider() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public com.vicheGallery.auth.dto.TokenResponse login(@org.jetbrains.annotations.NotNull()
    com.vicheGallery.auth.dto.TokenRequest request) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public com.vicheGallery.auth.domain.LoginUser findMemberByToken(@org.jetbrains.annotations.Nullable()
    java.lang.String credentials) {
        return null;
    }
}