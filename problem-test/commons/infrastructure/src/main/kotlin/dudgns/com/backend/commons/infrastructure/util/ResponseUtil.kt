package kr.co.hmcnetworks.backoffice.commons.infrastructure.util

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ResponseUtil {
    companion object {
        /** ok() */
        fun ok(data: Any?): ResponseEntity<Any> {
            return ResponseEntity(data, HttpStatus.OK)
        }

        /** basic error */
        fun error(data: Any? = null, code: HttpStatus? = null): ResponseEntity<Any> {
            var newData = data
            var newCode = code ?: HttpStatus.INTERNAL_SERVER_ERROR

            if (newData.toString().isBlank() || newData.toString().equals("null")) {
                newData = internalServerError()
            }

            return ResponseEntity(newData, newCode)
        }

        /** Bad Request */
        fun badRequest(data: Any? = null): ResponseEntity<Any> {
            return error(data, HttpStatus.BAD_REQUEST)
        }

        /** Method Not Allowed */
        fun methodNotAllowed(data: Any? = null): ResponseEntity<Any> {
            return error(data, HttpStatus.METHOD_NOT_ALLOWED)
        }

        /** Forbidden */
        fun forbidden(data: Any? = null): ResponseEntity<Any> {
            return error(data, HttpStatus.FORBIDDEN)
        }

        /** Internal Server Error */
        fun internalServerError(data: Any? = null): ResponseEntity<Any> {
            return error(data, HttpStatus.INTERNAL_SERVER_ERROR)
        }

        /** Unprocessable Entity */
        fun unprocessableEntity(data: Any? = null): ResponseEntity<Any> {
            return error(data, HttpStatus.UNPROCESSABLE_ENTITY)
        }
    }
}
