package com.armarti.annotationspractice

import com.armarti.annotationspractice.annotations.KAnnotatedSample

fun main(args: Array<String>) {

    println("KAnnotationReader.readAnnotations(KAnnotatedSample.class):")
    KAnnotationReader.readAnnotations(KAnnotatedSample::class)

    val kas = KAnnotatedSample()
    kas.doStuff()

}
