package com.vicheGallery.member.domain

import com.vicheGallery.BaseEntity
import com.vicheGallery.auth.exception.AuthorizationException
import javax.persistence.*

@Entity
class Member(
    val email: String,
    val password: String,
    val nickname: String,

    @Enumerated(EnumType.STRING)
    val ssoType: SsoType,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) : BaseEntity() {
    fun checkPassword(password: String?) {
        if (this.password != password) {
            throw AuthorizationException("아이디 암호를 확인해 주세요.")
        }
    }
}