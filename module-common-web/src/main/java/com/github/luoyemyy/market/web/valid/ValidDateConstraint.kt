//package com.github.luoyemyy.market.web.valid
//
//import com.github.luoyemyy.market.common.utils.DateUtils
//import javax.validation.ConstraintValidator
//import javax.validation.ConstraintValidatorContext
//
//class ValidDateConstraint : ConstraintValidator<ValidDate, String?> {
//    private var notNull = false
//    private var format: String? = null
//    override fun initialize(constraintAnnotation: ValidDate) {
//        notNull = constraintAnnotation.notNull
//        format = constraintAnnotation.format
//    }
//
//    override fun isValid(value: String?, context: ConstraintValidatorContext): Boolean {
//        return if (value.isNullOrEmpty()) {
//            if (notNull) {
//                //必须不为空
//                setInvalid(context)
//            } else {
//                true
//            }
//        } else {
//            if (DateUtils.parse(value, format) == null) {
//                //格式匹配失败
//                setInvalid(context)
//            } else {
//                true
//            }
//        }
//    }
//
//    private fun setInvalid(context: ConstraintValidatorContext): Boolean {
//        context.disableDefaultConstraintViolation()
//        context.buildConstraintViolationWithTemplate(invalidMsg()).addConstraintViolation()
//        return false
//    }
//
//    private fun invalidMsg(): String {
//        val stringBuilder = StringBuilder()
//        if (notNull) {
//            stringBuilder.append("不能为null，并且")
//        } else {
//            stringBuilder.append("可以为null，或者")
//        }
//        stringBuilder.append("格式必须为：$format")
//        return stringBuilder.toString()
//    }
//}