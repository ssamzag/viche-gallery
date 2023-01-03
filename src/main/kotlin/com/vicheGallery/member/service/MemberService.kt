package com.vicheGallery.member.service

import com.vicheGallery.member.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {

}
