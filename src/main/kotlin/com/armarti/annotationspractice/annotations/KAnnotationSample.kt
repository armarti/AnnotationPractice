package com.armarti.annotationspractice.annotations

// no inherited annotations in Kotlin
// see: https://youtrack.jetbrains.com/issue/KT-22265
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@MustBeDocumented
annotation class KAnnotationSample(
        val required: KAnnotationUsedInOtherAnnotation,
        val optional1: KAnnotationUsedInOtherAnnotation =
                KAnnotationUsedInOtherAnnotation(id = 1, name = "Name1"),
        val optional2: KAnnotationUsedInOtherAnnotation =
                KAnnotationUsedInOtherAnnotation(id = 1, name = "Name2", description = "desc-ription"),
        val req: String,
        val opt: String = "hehhe hoohoo"
)
