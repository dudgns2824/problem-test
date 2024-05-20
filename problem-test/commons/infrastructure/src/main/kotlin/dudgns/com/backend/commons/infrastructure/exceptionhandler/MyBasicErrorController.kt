package kr.co.hmcnetworks.backoffice.commons.infrastructure.exceptionhandler

import jakarta.servlet.http.HttpServletRequest
import org.springframework.boot.autoconfigure.web.ServerProperties
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController
import org.springframework.boot.web.servlet.error.ErrorAttributes
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class MyBasicErrorController(
    private val errorAttributes: ErrorAttributes,
    private val serverProperties: ServerProperties
) : BasicErrorController(errorAttributes, serverProperties.error) {

    @RequestMapping
    override fun error(request: HttpServletRequest): ResponseEntity<MutableMap<String, Any>> {
        val status = getStatus(request)
        return if (status == HttpStatus.NO_CONTENT) {
            ResponseEntity.status(status).build()
        } else {
            val body = getErrorAttributes(request, getErrorAttributeOptions(request, MediaType.ALL))

            // "code"라는 property에 "status" 프로퍼티 값 담기
            body["code"] = body["status"]

            // "status"라는 property는 제거
            body.remove("status")

            ResponseEntity(body, status)
        }
    }
}
