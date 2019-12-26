package com.armarti.annotationspractice;

import java.lang.annotation.Annotation;
import com.armarti.annotationspractice.annotations.JAnnotationSample;

public class JAnnotationReader {

    public static void readAnnotations(Class<?> annotated) {

        System.out.printf("Annotations for class '%s':%n", annotated.getName());
        Annotation[] annotations = annotated.getAnnotations();

        for(Annotation a : annotations) {

            System.out.printf("\t%s = %s%n", "a.toString()", a.toString());

            Class<?> at = a.annotationType();
            System.out.printf("\t%s = %s%n", "at.getSimpleName()", at.getSimpleName());

            JAnnotationSample ca = (JAnnotationSample) a;

            System.out.printf("\t%s = %s%n", "ca.required()", ca.required());
            System.out.printf("\t%s = %s%n", "ca.required().description()", ca.required().description());
            System.out.printf("\t%s = %s%n", "ca.required().id()", ca.required().id());
            System.out.printf("\t%s = %s%n", "ca.required().name()", ca.required().name());

            System.out.printf("\t%s = %s%n", "ca.optional1()", ca.optional1());
            System.out.printf("\t%s = %s%n", "ca.optional1().description()", ca.optional1().description());
            System.out.printf("\t%s = %s%n", "ca.optional1().id()", ca.optional1().id());
            System.out.printf("\t%s = %s%n", "ca.optional1().name()", ca.optional1().name());

            System.out.printf("\t%s = %s%n", "ca.optional2()", ca.optional2());
            System.out.printf("\t%s = %s%n", "ca.optional2().description()", ca.optional2().description());
            System.out.printf("\t%s = %s%n", "ca.optional2().id()", ca.optional2().id());
            System.out.printf("\t%s = %s%n", "ca.optional2().name()", ca.optional2().name());

            System.out.printf("\t%s = %s%n", "ca.req()", ca.req());
            System.out.printf("\t%s = %s%n", "ca.opt()", ca.opt());

        }
    }
}
