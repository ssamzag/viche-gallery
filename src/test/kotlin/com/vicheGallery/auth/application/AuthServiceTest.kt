package com.vicheGallery.auth.application

import com.vicheGallery.auth.dto.TokenRequest
import com.vicheGallery.auth.exception.AuthorizationException
import com.vicheGallery.member.domain.Member
import com.vicheGallery.member.repository.MemberRepository
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
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
    @DisplayName("로그인 기능에 잘못된 아이디 입력시 예외가 발생한다")
    fun loginFailTest() {
        // given
        val tokenRequest = TokenRequest("testx", "1234")

        // when & then
        assertThatThrownBy { authService.login(tokenRequest) }
            .isExactlyInstanceOf(AuthorizationException::class.java)
            .hasMessage("아이디 암호를 확인해 주세요.")
    }

    @Test
    @DisplayName("로그인 기능에 잘못된 암호 입력시 예외가 발생한다")
    fun loginFailTest2() {
        // given
        val tokenRequest = TokenRequest("test1", "12341")

        // when & then
        assertThatThrownBy { authService.login(tokenRequest) }
            .isExactlyInstanceOf(AuthorizationException::class.java)
            .hasMessage("아이디 암호를 확인해 주세요.")
    }

    @Test
    @DisplayName("토큰으로 유저정보를 반환하는 기능이 정상 동작한다")
    fun findMemberByTokenTest() {
        // given
        val login = authService.login(TokenRequest("test", "1234"))

        // when
        val result = authService.findMemberByToken(login?.accessToken)

        //then
        assertThat(result?.email).isEqualTo("test")
    }

    @Test
    @DisplayName("토큰으로 유저정보를 반환하는 기능이 유효하지 않은 토큰이 입력되면 예외가 발생한다")
    fun findMemberByTokenExceptionTest() {
        assertThatThrownBy { authService.findMemberByToken("FAIL_TOKEN") }
            .isExactlyInstanceOf(AuthorizationException::class.java)
            .hasMessage("권한 없음")
    }

    @Test
    @DisplayName("토큰은 유효하지만 유저 정보가 삭제된 경우 예외가 발생한다")
    fun findMemberByTokenExceptionTest2() {
        // given
        val member = memberRepository.save(Member("id", "1234", "nick"))
        val token = authService.login(TokenRequest("id", "1234"))?.accessToken
        memberRepository.delete(member)

        // when & then
        assertThatThrownBy { authService.findMemberByToken(token) }
            .isExactlyInstanceOf(RuntimeException::class.java)
    }
}