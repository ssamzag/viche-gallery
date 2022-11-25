package com.vicheGallery.member.domain

import com.vicheGallery.BaseEntity
import com.vicheGallery.auth.exception.AuthorizationException
import javax.persistence.*

@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val email: String,
    private val password: String,
    val nickname: String,

    @Enumerated(EnumType.STRING)
    val ssoType: SsoType
) : BaseEntity() {

    fun checkPassword(password: String?) {
        if (this.password != password) {
            throw AuthorizationException("아이디 암호를 확인해 주세요.")
        }
    }
}