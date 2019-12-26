package com.armarti.annotationspractice

import com.armarti.annotationspractice.annotations.KAnnotationSample
import kotlin.reflect.KClass

object KAnnotationReader {

    fun readAnnotations(annotated: KClass<*>) {

        println("Annotations for class '${annotated.simpleName}':")
        val  annotations = annotated.annotations

        for(a in annotations) {

            println("\ta = $a")

            val  at = a::class
            println("\tat = $at")

            val ca = a as KAnnotationSample

            println("\tca.required = ${ca.required}")
            println("\tca.required.description = ${ca.required.description}")
            println("\tca.required.id = ${ca.required.id}")
            println("\tca.required.name = ${ca.required.name}")

            println("\tca.optional1 = ${ca.optional1}")
            println("\tca.optional1.description = ${ca.optional1.description}")
            println("\tca.optional1.id = ${ca.optional1.id}")
            println("\tca.optional1.name = ${ca.optional1.name}")

            println("\tca.optional2 = ${ca.optional2}")
            println("\tca.optional2.description = ${ca.optional2.description}")
            println("\tca.optional2.id = ${ca.optional2.id}")
            println("\tca.optional2.name = ${ca.optional2.name}")

            println("\tca.req = ${ca.req}")
            println("\tca.opt = ${ca.opt}")

        }
    }
}
