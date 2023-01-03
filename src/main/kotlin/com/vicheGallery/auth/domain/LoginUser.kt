package com.vicheGallery.auth.domain

data class LoginUser(
    val email: String,
    val nickname: String?,
    val id: Long? = null
)