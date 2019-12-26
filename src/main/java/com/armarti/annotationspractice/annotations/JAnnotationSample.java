package com.armarti.annotationspractice.annotations;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Documented;

/**
 * This indicates that subclasses of an annotated type will
 * inherit the annotation.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented  // show this annotation in JavaDocs
public @interface JAnnotationSample {
    JAnnotationUsedInOtherAnnotation required();
    JAnnotationUsedInOtherAnnotation optional1()
            default @JAnnotationUsedInOtherAnnotation(id = 1, name = "Name1");
    JAnnotationUsedInOtherAnnotation optional2()
            default @JAnnotationUsedInOtherAnnotation(id = 1, name = "Name2", description = "desc-ription");
    String req();
    String opt() default "hehhe hoohoo";
}
