package com.vicheGallery.auth.ui

import com.vicheGallery.auth.application.AuthService
import com.vicheGallery.auth.dto.TokenRequest
import com.vicheGallery.auth.dto.TokenResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService
) {
    @PostMapping("/login/token")
    fun login(@RequestBody request: TokenRequest): ResponseEntity<TokenResponse?>? {
        val token = authService.login(request)
        return ResponseEntity.ok().body<TokenResponse?>(token)
    }
}