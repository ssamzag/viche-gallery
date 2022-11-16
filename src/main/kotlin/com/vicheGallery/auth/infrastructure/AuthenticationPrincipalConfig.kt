package com.vicheGallery.auth.infrastructure

import com.vicheGallery.auth.application.AuthService
import com.vicheGallery.auth.ui.AuthenticationPrincipalArgumentResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class AuthenticationPrincipalConfig(
    @Autowired
    val authService: AuthService
) : WebMvcConfigurer {

    override fun addArgumentResolvers(argumentResolvers: MutableList<HandlerMethodArgumentResolver>) {
        argumentResolvers.add(createAuthenticationPrincipalArgumentResolver())
    }

    @Bean
    fun createAuthenticationPrincipalArgumentResolver(): AuthenticationPrincipalArgumentResolver {
        return AuthenticationPrincipalArgumentResolver(authService)
    }
}