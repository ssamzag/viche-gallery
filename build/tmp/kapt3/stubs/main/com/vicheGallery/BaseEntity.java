package com.vicheGallery;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/vicheGallery/BaseEntity;", "", "()V", "createdDate", "Ljava/time/LocalDateTime;", "getCreatedDate", "()Ljava/time/LocalDateTime;", "modifiedDate", "getModifiedDate", "vicheGallery"})
@javax.persistence.EntityListeners(value = {org.springframework.data.jpa.domain.support.AuditingEntityListener.class})
@javax.persistence.MappedSuperclass()
public abstract class BaseEntity {
    @org.jetbrains.annotations.NotNull()
    @javax.persistence.Column(nullable = false, updatable = false)
    @org.springframework.data.annotation.CreatedDate()
    private final java.time.LocalDateTime createdDate = null;
    @org.jetbrains.annotations.NotNull()
    @javax.persistence.Column(nullable = false)
    @org.springframework.data.annotation.LastModifiedBy()
    private final java.time.LocalDateTime modifiedDate = null;
    
    public BaseEntity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDateTime getCreatedDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDateTime getModifiedDate() {
        return null;
    }
}