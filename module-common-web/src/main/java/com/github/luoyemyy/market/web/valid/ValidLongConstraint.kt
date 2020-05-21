package com.github.luoyemyy.market.web.valid

import java.util.*
import java.util.stream.*
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class ValidLongConstraint : ConstraintValidator<ValidLong, Long?> {
    private var notNull = false
    private var values: List<Long> = listOf()
    private var min: Long = 0
    private var max: Long = 0
    override fun initialize(constraintAnnotation: ValidLong) {
        min = constraintAnnotation.min
        max = constraintAnnotation.max
        values = Arrays.stream(constraintAnnotation.values).boxed().collect(Collectors.toList())
        notNull = constraintAnnotation.notNull
    }

    override fun isValid(value: Long?, context: ConstraintValidatorContext): Boolean {
        // 匹配顺序：notNull > values > min&max
        return if (value == null) {
            if (notNull) {
                //必须不为null
                setInvalid(context)
            } else {
                true
            }
        } else if (!values.isNullOrEmpty()) {
            if (!values.contains(value)) {
                //不是已定义数字
                setInvalid(context)
            } else {
                true
            }
        } else {
            if (value < min || value > max) {
                //不在范围内
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
        if (notNull) {
            stringBuilder.append("不能为null，并且")
        } else {
            stringBuilder.append("可以为null，或者")
        }
        if (!values.isNullOrEmpty()) {
            stringBuilder.append("必须为：$values")
        } else {
            stringBuilder.append("必须>=$min")
            if (max < Int.MAX_VALUE) {
                stringBuilder.append("，必须<=$max")
            }
        }
        return stringBuilder.toString()
    }
}