package com.armarti.annotationspractice.annotations

@Retention(AnnotationRetention.SOURCE)
@Target()
annotation class KAnnotationUsedInOtherAnnotation(
        val id: Int,
        val name: String,
        val description: String = "default description"
)

