package com.armarti.annotationspractice.annotations

@KAnnotationSample(
        required = KAnnotationUsedInOtherAnnotation(id = 3, name = "nom"),
        req = "req'd field"
)
class KAnnotatedSample {
    fun doStuff() = println("I'm doing stuff in Kotlinland!")
}
