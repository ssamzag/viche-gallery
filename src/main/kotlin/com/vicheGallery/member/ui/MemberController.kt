package com.vicheGallery.member.ui

import com.vicheGallery.member.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class MemberController {

    @GetMapping
    fun login(@Autowired memberService: MemberService) {

    }
}