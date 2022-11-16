package com.vicheGallery.post.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0017J\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\u0017J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\bH\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/vicheGallery/post/ui/PostController;", "", "postService", "Lcom/vicheGallery/post/application/PostService;", "(Lcom/vicheGallery/post/application/PostService;)V", "getPostService", "()Lcom/vicheGallery/post/application/PostService;", "createPost", "Lorg/springframework/http/ResponseEntity;", "", "request", "Lcom/vicheGallery/post/dto/PostRequest;", "user", "Lcom/vicheGallery/auth/domain/LoginUser;", "getPost", "Lcom/vicheGallery/post/dto/PostRead;", "postId", "", "getPosts", "Lcom/vicheGallery/post/dto/PostsResponse;", "vicheGallery"})
@org.springframework.web.bind.annotation.RequestMapping(value = {"/posts"})
@org.springframework.web.bind.annotation.RestController()
public class PostController {
    @org.jetbrains.annotations.NotNull()
    private final com.vicheGallery.post.application.PostService postService = null;
    
    public PostController(@org.jetbrains.annotations.NotNull()
    com.vicheGallery.post.application.PostService postService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.vicheGallery.post.application.PostService getPostService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.PostMapping()
    public org.springframework.http.ResponseEntity<java.lang.String> createPost(@org.jetbrains.annotations.NotNull()
    @javax.validation.Valid()
    @org.springframework.web.bind.annotation.RequestBody()
    com.vicheGallery.post.dto.PostRequest request, @org.jetbrains.annotations.NotNull()
    @com.vicheGallery.auth.domain.AuthenticationPrincipal()
    com.vicheGallery.auth.domain.LoginUser user) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.GetMapping()
    public org.springframework.http.ResponseEntity<com.vicheGallery.post.dto.PostsResponse> getPosts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.springframework.web.bind.annotation.GetMapping(value = {"/{postId}"})
    public org.springframework.http.ResponseEntity<com.vicheGallery.post.dto.PostRead> getPost(@org.springframework.web.bind.annotation.PathVariable()
    long postId) {
        return null;
    }
}