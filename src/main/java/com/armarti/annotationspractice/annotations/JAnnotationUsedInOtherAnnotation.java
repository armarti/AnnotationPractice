package com.armarti.annotationspractice.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * As long as this annotation is only used as a type in
 * other com.armarti.annotationspractice.annotations, its RuntimePolicy does not matter.
 * (at least this is true in JDK 1.6)
 */
@Retention(RetentionPolicy.SOURCE)
/**
 * This also doesn't matter when using the annotation
 * as a type for other com.armarti.annotationspractice.annotations. Using {} should
 * guarantee that it can _only_ be used as a type
 * for other com.armarti.annotationspractice.annotations.
 */
@Target({})
public @interface JAnnotationUsedInOtherAnnotation {
    int id();
    String name();
    String description() default "default description";
}
