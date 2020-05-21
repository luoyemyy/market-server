package com.github.luoyemyy.market.web.advice

import com.github.luoyemyy.market.web.swagger.ApiResponse
import org.slf4j.LoggerFactory
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import javax.validation.ConstraintViolationException
import javax.validation.Path

@RestControllerAdvice
class AppAdvice {

    private val logger = LoggerFactory.getLogger(AppAdvice::class.java)

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun paramError(e: MethodArgumentNotValidException): ApiResponse {
        val msg = e.bindingResult.fieldErrors.joinToString(",") {
            "${it.field}:${it.defaultMessage}"
        }
        logger.error("AppAdvice.paramError：{}", msg)
        return getResponse(AppCode.ERROR_PARAM.throws(msg))
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun paramError(e: ConstraintViolationException): ApiResponse {
        val msg = e.constraintViolations.joinToString(",") {
            "${getPathName(it.propertyPath)}:${it.message}"
        }
        logger.error("AppAdvice.paramError：{}", msg)
        return getResponse(AppCode.ERROR_PARAM.throws(msg))
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun paramError(e: MethodArgumentTypeMismatchException): ApiResponse {
        logger.error("AppAdvice.paramError：{}", e.message, e)
        return getResponse(AppCode.ERROR_PARAM.throws(e.message))
    }

    @ExceptionHandler(AppException::class)
    fun appError(e: AppException): ApiResponse {
        logger.error("AppAdvice.appError：{}", e.errorMsg(), e)
        return getResponse(e)
    }

    @ExceptionHandler(Throwable::class)
    fun throwable(e: Throwable): ApiResponse {
        logger.error("AppAdvice.throwable：{}", e.message, e)
        return getResponse(AppCode.FAIL.throws(e.message))
    }

    private fun getResponse(e: AppException): ApiResponse {
        return ApiResponse().apply {
            code = e.code()
            codeMsg = e.codeMsg()
            errorMsg = e.errorMsg()
        }
    }

    private fun getPathName(path: Path?): String? {
        val iterator: Iterator<Path.Node> = path?.iterator() ?: return null
        var name: String? = null
        while (iterator.hasNext()) {
            name = iterator.next().name
        }
        return name
    }
}