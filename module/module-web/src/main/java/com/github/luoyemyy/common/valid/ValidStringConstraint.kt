package com.github.luoyemyy.common.valid

import com.github.luoyemyy.common.util.RegUtil
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class ValidStringConstraint : ConstraintValidator<ValidString, String?> {
    private var notnull: Boolean = false
    private var values: Array<String> = arrayOf()
    private var min: Int = 0
    private var max: Int = 0
    private var pattern: String = ""
    override fun initialize(constraintAnnotation: ValidString) {
        notnull = constraintAnnotation.notnull
        values = constraintAnnotation.values
        min = constraintAnnotation.min
        max = constraintAnnotation.max
        pattern = constraintAnnotation.pattern
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext): Boolean {
        return if (value == null) {
            if (notnull) {
                //必须不为null
                setInvalid(context)
            } else {
                true
            }
        } else if (values.isNotEmpty()) {
            if (!values.contains(value)) {
                //不是已定义字符串
                setInvalid(context)
            } else {
                true
            }
        } else {
            if (value.length < min || value.length > max) {
                //不在范围内
                setInvalid(context)
            } else {
                true
            } && if (pattern.isNotEmpty() && !RegUtil.match(pattern, value)) {
                //有正则匹配规则，但是不匹配
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
        if (values.isNotEmpty()) {
            stringBuilder.append("必须为：$values")
        } else {
            stringBuilder.append("必须长度>=$min")
            if (max < Int.MAX_VALUE) {
                stringBuilder.append("，必须长度<=$max")
            }
            if (pattern.isNotEmpty()) {
                stringBuilder.append("且必须匹配正则：$pattern")
            }
        }
        return stringBuilder.toString()
    }
}