package kr.co.hmcnetworks.backoffice.commons.infrastructure.util

import org.springframework.security.core.context.SecurityContextHolder

class AuthNUtil {
    companion object {
        fun getPrincipal(): Any {
            return SecurityContextHolder.getContext().authentication.principal
        }

        fun getDetails(): Any {
            return SecurityContextHolder.getContext().authentication.details
        }
    }
}