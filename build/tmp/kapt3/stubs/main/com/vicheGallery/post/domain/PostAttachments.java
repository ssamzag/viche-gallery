package com.vicheGallery.post.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0003R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/vicheGallery/post/domain/PostAttachments;", "", "attachments", "", "Lcom/vicheGallery/post/domain/PostAttachment;", "(Ljava/util/List;)V", "getAttachments", "()Ljava/util/List;", "firstFile", "", "getFileUrl", "vicheGallery"})
@javax.persistence.Embeddable()
public final class PostAttachments {
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.OneToMany(mappedBy = "post", cascade = {javax.persistence.CascadeType.ALL}, orphanRemoval = true)
    private final java.util.List<com.vicheGallery.post.domain.PostAttachment> attachments = null;
    
    public PostAttachments() {
        super();
    }
    
    public PostAttachments(@org.jetbrains.annotations.Nullable()
    java.util.List<com.vicheGallery.post.domain.PostAttachment> attachments) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.vicheGallery.post.domain.PostAttachment> getAttachments() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getFileUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String firstFile() {
        return null;
    }
}