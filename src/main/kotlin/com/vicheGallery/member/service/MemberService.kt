package com.vicheGallery.member.service

import com.vicheGallery.member.domain.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MemberService (
    @Autowired
    memberRepository: MemberRepository
        ){

}
