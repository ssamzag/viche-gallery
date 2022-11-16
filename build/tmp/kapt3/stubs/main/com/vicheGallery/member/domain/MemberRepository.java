package com.vicheGallery.member.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/vicheGallery/member/domain/MemberRepository;", "Lorg/springframework/data/jpa/repository/JpaRepository;", "Lcom/vicheGallery/member/domain/Member;", "", "findByEmail", "email", "", "vicheGallery"})
@org.springframework.stereotype.Repository()
public abstract interface MemberRepository extends org.springframework.data.jpa.repository.JpaRepository<com.vicheGallery.member.domain.Member, java.lang.Long> {
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.vicheGallery.member.domain.Member findByEmail(@org.jetbrains.annotations.Nullable()
    java.lang.String email);
}