package com.vicheGallery.auth.ui

import com.vicheGallery.auth.application.AuthService
import com.vicheGallery.auth.domain.AuthenticationPrincipal
import com.vicheGallery.auth.infrastructure.AuthorizationExtractor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.MethodParameter
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer
import javax.servlet.http.HttpServletRequest

class AuthenticationPrincipalArgumentResolver(
    private val authService: AuthService
) : HandlerMethodArgumentResolver {

    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.hasParameterAnnotation(AuthenticationPrincipal::class.java)
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?
    ): Any? {
        val credentials = AuthorizationExtractor.extract(webRequest.getNativeRequest(HttpServletRequest::class.java)!!)
        return authService.findMemberByToken(credentials)
    }
}
