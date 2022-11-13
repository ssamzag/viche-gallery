package com.vicheGallery.work.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/vicheGallery/work/domain/WorkAttachment;", "", "id", "", "storedName", "", "work", "Lcom/vicheGallery/work/domain/Work;", "(Ljava/lang/Long;Ljava/lang/String;Lcom/vicheGallery/work/domain/Work;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStoredName", "()Ljava/lang/String;", "getWork", "()Lcom/vicheGallery/work/domain/Work;", "vicheGallery"})
@javax.persistence.Entity()
public final class WorkAttachment {
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id()
    private final java.lang.Long id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String storedName = null;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.JoinColumn(name = "work_id")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.LAZY, cascade = {javax.persistence.CascadeType.PERSIST})
    private final com.vicheGallery.work.domain.Work work = null;
    
    public WorkAttachment(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.NotNull()
    java.lang.String storedName, @org.jetbrains.annotations.Nullable()
    com.vicheGallery.work.domain.Work work) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStoredName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.vicheGallery.work.domain.Work getWork() {
        return null;
    }
}