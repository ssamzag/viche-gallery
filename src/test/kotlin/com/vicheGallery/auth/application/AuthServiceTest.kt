package com.vicheGallery.auth.application

import com.vicheGallery.auth.dto.TokenRequest
import com.vicheGallery.member.repository.MemberRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AuthServiceTest @Autowired constructor(
    private val authService: AuthService,
    private val memberRepository: MemberRepository
) {
    @Test
    @DisplayName("로그인 기능이 정상 동작한다")
    fun loginTest() {
        // given & when
        val login = authService.login(TokenRequest("test", "1234"))

        // then
        assertThat(login?.accessToken).isNotNull
    }
    @Test
    @DisplayName("로그인 기능이 정상 동작한다")
    fun loginFailTest() {
        // given & when
        val login = authService.login(TokenRequest("test", "1234"))

        // then
        assertThat(login?.accessToken).isNotNull
    }

    @Test
    fun findMemberByToken() {
    }
}