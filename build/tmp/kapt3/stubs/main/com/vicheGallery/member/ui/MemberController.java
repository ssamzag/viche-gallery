package com.vicheGallery.member.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0017\u00a8\u0006\u0007"}, d2 = {"Lcom/vicheGallery/member/ui/MemberController;", "", "()V", "login", "", "memberService", "Lcom/vicheGallery/member/service/MemberService;", "vicheGallery"})
@org.springframework.web.bind.annotation.RequestMapping(value = {"/member"})
@org.springframework.web.bind.annotation.RestController()
public class MemberController {
    
    public MemberController() {
        super();
    }
    
    @org.springframework.web.bind.annotation.GetMapping()
    public void login(@org.jetbrains.annotations.NotNull()
    @org.springframework.beans.factory.annotation.Autowired()
    com.vicheGallery.member.service.MemberService memberService) {
    }
}