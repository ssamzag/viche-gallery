package com.vicheGallery.post.application;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0017\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017\u00a2\u0006\u0002\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/vicheGallery/post/application/PostService;", "", "postRepository", "Lcom/vicheGallery/post/domain/PostRepository;", "(Lcom/vicheGallery/post/domain/PostRepository;)V", "getPostRepository", "()Lcom/vicheGallery/post/domain/PostRepository;", "findAllDesc", "Lcom/vicheGallery/post/dto/PostsResponse;", "findByPostId", "Lcom/vicheGallery/post/dto/PostRead;", "postId", "", "write", "postRequest", "Lcom/vicheGallery/post/dto/PostRequest;", "(Lcom/vicheGallery/post/dto/PostRequest;)Ljava/lang/Long;", "vicheGallery"})
@org.springframework.transaction.annotation.Transactional(readOnly = true)
@org.springframework.stereotype.Service()
public class PostService {
    @org.jetbrains.annotations.NotNull()
    private final com.vicheGallery.post.domain.PostRepository postRepository = null;
    
    public PostService(@org.jetbrains.annotations.NotNull()
    com.vicheGallery.post.domain.PostRepository postRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.vicheGallery.post.domain.PostRepository getPostRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @org.springframework.transaction.annotation.Transactional(readOnly = false)
    public java.lang.Long write(@org.jetbrains.annotations.NotNull()
    com.vicheGallery.post.dto.PostRequest postRequest) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.vicheGallery.post.dto.PostRead findByPostId(long postId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.vicheGallery.post.dto.PostsResponse findAllDesc() {
        return null;
    }
}