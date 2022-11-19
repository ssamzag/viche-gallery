package com.vicheGallery

import javax.servlet.http.HttpServletRequest


class RemoteAddr {
    fun getClientIp(request: HttpServletRequest): String? {
        var ip = request.getHeader("X-Real-IP")

        if (isEmptyOrUnknown(ip)) {
            ip = request.getHeader("X-RealIP")
        }
        if (isEmptyOrUnknown(ip)) {
            ip = request.getHeader("X-Real_IP")
        }
        if (isEmptyOrUnknown(ip)) {
            ip = request.getHeader("Proxy-Client-IP")
        }
        if (isEmptyOrUnknown(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP")
        }
        if (isEmptyOrUnknown(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP")
        }
        if (isEmptyOrUnknown(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR")
        }
        if (isEmptyOrUnknown(ip)) {
            ip =  request.getHeader("x-original-forwarded-for")
        }
        if (isEmptyOrUnknown(ip)) {
            ip = request.getHeader("REMOTE_ADDR")
        }
        if (isEmptyOrUnknown(ip)) {
            ip = request.remoteAddr
        }
        return ip
    }

    private fun isEmptyOrUnknown(ip: String?) = ip.isNullOrEmpty() || "unknown" == ip
}