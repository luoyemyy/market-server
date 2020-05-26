package com.github.luoyemyy.common.valid

import com.github.luoyemyy.common.util.parse
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class ValidDateConstraint : ConstraintValidator<ValidDate, String?> {
    private var notnull = false
    private var format: String = ""
    override fun initialize(constraintAnnotation: ValidDate) {
        notnull = constraintAnnotation.notnull
        format = constraintAnnotation.format
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext): Boolean {
        return if (value.isNullOrEmpty()) {
            if (notnull) {
                //必须不为空
                setInvalid(context)
            } else {
                true
            }
        } else {
            if (value.parse(format) == null) {
                //格式匹配失败
                setInvalid(context)
            } else {
                true
            }
        }
    }

    private fun setInvalid(context: ConstraintValidatorContext): Boolean {
        context.disableDefaultConstraintViolation()
        context.buildConstraintViolationWithTemplate(invalidMsg()).addConstraintViolation()
        return false
    }

    private fun invalidMsg(): String {
        val stringBuilder = StringBuilder()
        if (notnull) {
            stringBuilder.append("不能为null，并且")
        } else {
            stringBuilder.append("可以为null，或者")
        }
        stringBuilder.append("格式必须为：$format")
        return stringBuilder.toString()
    }
}