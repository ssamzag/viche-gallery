package com.vicheGallery.auth.domain

data class LoginUser(
    val id: Long? = null,
    val email: String? = null,
    val nickname: String? = null
)