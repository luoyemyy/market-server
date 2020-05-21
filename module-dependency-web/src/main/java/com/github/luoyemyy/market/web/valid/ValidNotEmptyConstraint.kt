package com.github.luoyemyy.market.web.valid

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class ValidNotEmptyConstraint : ConstraintValidator<ValidNotEmpty?, String?> {
    override fun initialize(constraintAnnotation: ValidNotEmpty?) {}
    override fun isValid(value: String?, context: ConstraintValidatorContext): Boolean {
        return !value.isNullOrEmpty()
    }
}