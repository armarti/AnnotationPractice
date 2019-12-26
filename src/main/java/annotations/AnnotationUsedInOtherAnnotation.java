package annotations;

public @interface AnnotationUsedInOtherAnnotation {
    int id();
    String name();
    String description() default "default description";
}
