package com.github.luoyemyy.common.aspect

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MustBeDocumented
annotation class AppApi(val id: Long = 0, val auth: Boolean = true) 