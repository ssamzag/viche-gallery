package com.vicheGallery.post.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\f\u001a\u00020\u00152\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/vicheGallery/post/domain/Post;", "Lcom/vicheGallery/BaseEntity;", "id", "", "title", "", "content", "attachments", "Lcom/vicheGallery/post/domain/PostAttachments;", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/vicheGallery/post/domain/PostAttachments;)V", "getAttachments", "()Lcom/vicheGallery/post/domain/PostAttachments;", "setAttachments", "(Lcom/vicheGallery/post/domain/PostAttachments;)V", "getContent", "()Ljava/lang/String;", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTitle", "firstFile", "", "", "vicheGallery"})
@javax.persistence.Entity()
public final class Post extends com.vicheGallery.BaseEntity {
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id()
    private final java.lang.Long id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    @javax.persistence.Lob()
    private final java.lang.String content = null;
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Embedded()
    private com.vicheGallery.post.domain.PostAttachments attachments;
    
    public Post(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.Nullable()
    com.vicheGallery.post.domain.PostAttachments attachments) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContent() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.vicheGallery.post.domain.PostAttachments getAttachments() {
        return null;
    }
    
    public final void setAttachments(@org.jetbrains.annotations.Nullable()
    com.vicheGallery.post.domain.PostAttachments p0) {
    }
    
    public final void setAttachments(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> attachments) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String firstFile() {
        return null;
    }
}