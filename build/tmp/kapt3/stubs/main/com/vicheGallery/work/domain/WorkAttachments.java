package com.vicheGallery.work.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/vicheGallery/work/domain/WorkAttachments;", "", "workAttachments", "", "Lcom/vicheGallery/work/domain/WorkAttachment;", "(Ljava/util/List;)V", "getWorkAttachments", "()Ljava/util/List;", "getFileUrl", "", "vicheGallery"})
@javax.persistence.Embeddable()
public final class WorkAttachments {
    @org.jetbrains.annotations.NotNull()
    @javax.persistence.OneToMany(mappedBy = "work", cascade = {javax.persistence.CascadeType.ALL}, orphanRemoval = true)
    private final java.util.List<com.vicheGallery.work.domain.WorkAttachment> workAttachments = null;
    
    public WorkAttachments(@org.jetbrains.annotations.NotNull()
    java.util.List<com.vicheGallery.work.domain.WorkAttachment> workAttachments) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.vicheGallery.work.domain.WorkAttachment> getWorkAttachments() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getFileUrl() {
        return null;
    }
}