package com.github.luoyemyy.common.valid

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@kotlin.annotation.Repeatable
@MustBeDocumented
@Constraint(validatedBy = [ValidStringConstraint::class])
annotation class ValidString(
        /**
         * 匹配顺序：notnull > values > min&max || pattern
         */
        val notnull: Boolean = true,
        val values: Array<String> = [],
        val min: Int = 1,
        val max: Int = Int.MAX_VALUE,
        val pattern: String = "",
        val message: String = "不能为null，不能为空",
        val groups: Array<KClass<*>> = [],
        val payload: Array<KClass<out Payload>> = []
) {
    @Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    @MustBeDocumented
    annotation class List(vararg val value: ValidString)
}