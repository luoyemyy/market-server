package com.github.luoyemyy.common.valid

import com.github.luoyemyy.common.util.DateUtil
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(allowedTargets = [AnnotationTarget.FUNCTION, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE])
@Retention(AnnotationRetention.RUNTIME)
@Repeatable
@Constraint(validatedBy = [ValidDateConstraint::class])
@MustBeDocumented
annotation class ValidDate(
        val notnull: Boolean = true,
        val format: String = DateUtil.FORMAT_YMD,
        val message: String = "不能为null，不能为空，必须是yyyy-MM-dd格式",
        val groups: Array<KClass<*>> = [],
        val payload: Array<KClass<out Payload>> = []
) {

    @Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE)
    @Retention(AnnotationRetention.RUNTIME)
    @MustBeDocumented
    annotation class List(vararg val value: ValidDate)

}