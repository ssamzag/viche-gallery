package com.vicheGallery.work.application;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/vicheGallery/work/application/WorkService;", "", "workRepository", "Lcom/vicheGallery/work/repository/WorkRepository;", "(Lcom/vicheGallery/work/repository/WorkRepository;)V", "getWorkRepository", "()Lcom/vicheGallery/work/repository/WorkRepository;", "create", "Lcom/vicheGallery/work/dto/WorkWriteResponse;", "request", "Lcom/vicheGallery/work/dto/WorkWriteRequest;", "findAll", "", "Lcom/vicheGallery/work/dto/WorkReadResponse;", "read", "id", "", "vicheGallery"})
@org.springframework.stereotype.Service()
public class WorkService {
    @org.jetbrains.annotations.NotNull()
    private final com.vicheGallery.work.repository.WorkRepository workRepository = null;
    
    public WorkService(@org.jetbrains.annotations.NotNull()
    com.vicheGallery.work.repository.WorkRepository workRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.vicheGallery.work.repository.WorkRepository getWorkRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.vicheGallery.work.dto.WorkWriteResponse create(@org.jetbrains.annotations.NotNull()
    com.vicheGallery.work.dto.WorkWriteRequest request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.vicheGallery.work.dto.WorkReadResponse read(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.util.List<com.vicheGallery.work.dto.WorkReadResponse> findAll() {
        return null;
    }
}