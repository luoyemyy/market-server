package com.github.luoyemyy.common.valid

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class ValidNotNullConstraint : ConstraintValidator<ValidNotNull?, Any?> {
    override fun initialize(constraintAnnotation: ValidNotNull?) {}
    override fun isValid(value: Any?, context: ConstraintValidatorContext): Boolean {
        return value != null
    }
}