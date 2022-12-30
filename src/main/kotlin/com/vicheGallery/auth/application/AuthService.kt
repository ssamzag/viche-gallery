package com.vicheGallery.auth.application

import com.vicheGallery.auth.domain.LoginUser
import com.vicheGallery.auth.dto.TokenRequest
import com.vicheGallery.auth.dto.TokenResponse
import com.vicheGallery.auth.exception.AuthorizationException
import com.vicheGallery.auth.infrastructure.JwtTokenProvider
import com.vicheGallery.member.domain.Member
import com.vicheGallery.member.domain.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val memberRepository: MemberRepository,
    private val jwtTokenProvider: JwtTokenProvider
) {
    fun login(request: TokenRequest): TokenResponse? {
        val member: Member = memberRepository.findByEmail(request.userid)
            ?: throw AuthorizationException("아이디 암호를 확인해 주세요.")

        member.checkPassword(request.password)
        val token = jwtTokenProvider.createToken(request.userid)
        return TokenResponse(token!!)
    }

    fun findMemberByToken(credentials: String?): LoginUser? {
        if (!jwtTokenProvider.validateToken(credentials)) {
            throw AuthorizationException("권한 없음")
        }
        val email = jwtTokenProvider.getPayload(credentials)
        val member: Member = memberRepository.findByEmail(email)
            ?: throw RuntimeException()

        return LoginUser(
            id = member.id,
            email = member.email,
            nickname = member.nickname
        )
    }
}
