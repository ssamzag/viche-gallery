package com.vicheGallery.auth.application

import com.vicheGallery.member.domain.Member
import com.vicheGallery.member.domain.MemberRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AuthServiceTest @Autowired constructor(
    private val authService: AuthService,
    private val memberRepository: MemberRepository
) {
    @BeforeEach
    fun init() {
        memberRepository.save(Member(""))
    }

    @AfterEach
    fun clear() {
        memberRepository.deleteAll()
    }

    @Test
    @DisplayName("로그인 기능이 정상 동작한다")
    fun loginTest() {
        // given


        // when

        // then
    }

    @Test
    fun findMemberByToken() {
    }
}