package dudgns.com.backend.commons.infrastructure.exceptionhandler

import jakarta.servlet.http.HttpServletRequest
import dudgns.com.backend.commons.infrastructure.util.ApiResponse
import dudgns.com.backend.commons.infrastructure.util.ResponseUtil
import org.springframework.core.NestedRuntimeException
import org.springframework.expression.ExpressionException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.HttpMediaTypeNotSupportedException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.HandlerMethodValidationException
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.servlet.NoHandlerFoundException
import java.io.FileNotFoundException
import java.io.IOException
import java.lang.reflect.InvocationTargetException
import java.net.BindException

/**
 * aop - exceptionAdvicer
 * - spring 의존적인 exception 이라, application/infrastructure layer 에 위치
 */
@RestControllerAdvice
class MyCustomExceptionHandler {

    @ExceptionHandler(
        value = [
            HandlerMethodValidationException::class // 유효성 검사 annotation 메서드 파리미터에 적용된 경우
        ],
    )
    fun handleHandlerMethodValidationException(
        request: HttpServletRequest,
        e: HandlerMethodValidationException,
    ): ResponseEntity<Any> {
        println(e.stackTraceToString())

        // RestControllerAdvice 처리 이후 뒷단에서도 예외 정보 사용목적(ex. 메시지 모듈에서 서버 예외 사용함)
        request.setAttribute("hmcnetworks.error.exception", e)

        val errors = mutableMapOf<String, String>()
        for (result in e.allValidationResults) {
            val fieldName = result.methodParameter.parameterName as String
            var defaultMsg = ""
            for (msg in result.resolvableErrors) defaultMsg += "${msg.defaultMessage} "
            errors[fieldName] = defaultMsg.trim()
        }

        val errRes = mutableMapOf<String, Any>()
        errRes["codeMessage"] = HttpStatus.BAD_REQUEST.reasonPhrase
        errRes["errors"] = errors

        val res = ApiResponse.error(
            code = HttpStatus.BAD_REQUEST.value(),
            message = errRes,
            path = request.requestURI,
            method = request.method,
        )

        return ResponseUtil.badRequest(res)
    }

    @ExceptionHandler(
        value = [
            MethodArgumentNotValidException::class, // javax.validation.Valid or @Validated 으로 binding error 발생시
        ],
    )
    fun handleMethodArgumentNotValidException(
        request: HttpServletRequest,
        e: Exception,
        bindingResult: BindingResult,
    ): ResponseEntity<Any> {
        println(e.stackTraceToString())

        request.setAttribute("hmcnetworks.error.exception", e)

        val errors = mutableMapOf<String, String>()

        bindingResult.allErrors.forEach { error ->
            val fieldName = if (error is FieldError) {
                error.field
            } else {
                error.code ?: "code"
            }
            errors[fieldName] = error.defaultMessage.toString()
        }

        val errRes = mutableMapOf<String, Any>()
        errRes["codeMessage"] = HttpStatus.BAD_REQUEST.reasonPhrase
        errRes["errors"] = errors

        val res = ApiResponse.error(
            code = HttpStatus.BAD_REQUEST.value(),
            message = errRes,
            path = request.requestURI,
            method = request.method,
        )

        return ResponseUtil.badRequest(res)
    }

    @ExceptionHandler(
        value = [
            BindException::class, //  @ModelAttribute 으로 binding error 발생시
            MethodArgumentTypeMismatchException::class, // enum type 일치하지 않아 binding 못할 경우 발생 (주로 @RequestParam enum으로 binding 못했을 경우 발생)
            MissingServletRequestParameterException::class,
            // ConstraintViolationException::class, // validation 결과
            HttpMessageNotReadableException::class,
            NoHandlerFoundException::class,
            HttpMediaTypeNotSupportedException::class,
            NoSuchElementException::class, // java.util.Optional<T> 객체로부터 get() 로 객체 접근시, null 인 경우
            NumberFormatException::class,
            NestedRuntimeException::class,
            NullPointerException::class,
            NoSuchFieldException::class,
            IllegalAccessException::class,
            IOException::class,
            FileNotFoundException::class,
            IllegalArgumentException::class,
            ExpressionException::class,
            InvocationTargetException::class,
        ],
    )
    fun handleBindException(
        request: HttpServletRequest,
        e: Exception,
    ): ResponseEntity<Any> {
        println(e.stackTraceToString())

        request.setAttribute("hmcnetworks.error.exception", e)

        val res = ApiResponse.error(
            code = HttpStatus.BAD_REQUEST.value(),
            message = "${HttpStatus.BAD_REQUEST.reasonPhrase} / ${e.message} / ${e.cause} / ${e.javaClass}",
            path = request.requestURI,
            method = request.method,
        )

        return ResponseUtil.badRequest(res)
    }

    @ExceptionHandler(value = [HttpRequestMethodNotSupportedException::class])
    fun handleHttpRequestMethodNotSupportedException(
        request: HttpServletRequest,
        e: Exception,
    ): ResponseEntity<Any> {
        println(e.stackTraceToString())

        request.setAttribute("hmcnetworks.error.exception", e)

        val res = ApiResponse.error(
            code = HttpStatus.METHOD_NOT_ALLOWED.value(),
            message = "${HttpStatus.METHOD_NOT_ALLOWED.reasonPhrase} / ${e.message} / ${e.cause} / ${e.javaClass}",
            path = request.requestURI,
            method = request.method,
        )

        return ResponseUtil.methodNotAllowed(res)
    }

    @ExceptionHandler(value = [AccessDeniedException::class])
    fun handleAccessDeniedException(
        request: HttpServletRequest,
        e: Exception,
    ): ResponseEntity<Any> {
        println(e.stackTraceToString())

        request.setAttribute("hmcnetworks.error.exception", e)

        val res = ApiResponse.error(
            code = HttpStatus.FORBIDDEN.value(),
            message = "${HttpStatus.FORBIDDEN.reasonPhrase} / ${e.message} / ${e.cause} / ${e.javaClass} - 권한이 부족합니다.",
            path = request.requestURI,
            method = request.method,
        )

        return ResponseUtil.forbidden(res)
    }

    @ExceptionHandler(
        value = [
            Exception::class,
            IllegalStateException::class,
        ],
    )
    fun handleException(
        request: HttpServletRequest,
        e: Exception,
    ): ResponseEntity<Any> {
        println(e.stackTraceToString())

        // 메시지 모듈에서 예외정보 사용중
        request.setAttribute("hmcnetworks.error.exception", e)

        val res = ApiResponse.error(
            code = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            message = "${HttpStatus.INTERNAL_SERVER_ERROR.reasonPhrase} / ${e.message} / ${e.cause} / ${e.javaClass}",
            path = request.requestURI,
            method = request.method,
        )

        return ResponseUtil.internalServerError(res)
    }
}
