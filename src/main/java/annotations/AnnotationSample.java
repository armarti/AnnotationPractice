package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface AnnotationSample {
    AnnotationUsedInOtherAnnotation required();
    AnnotationUsedInOtherAnnotation optional1()
            default @AnnotationUsedInOtherAnnotation(id=1, name="Name1");
    AnnotationUsedInOtherAnnotation optional2()
            default @AnnotationUsedInOtherAnnotation(id=1, name="Name2", description="desc-ription");
    String req();
    String opt() default "hehhe hoohoo";
}
