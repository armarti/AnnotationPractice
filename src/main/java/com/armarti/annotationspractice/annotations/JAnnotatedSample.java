package com.armarti.annotationspractice.annotations;

@JAnnotationSample(
        required = @JAnnotationUsedInOtherAnnotation(id = 3, name = "nom"),
        req = "req'd field"
)
public class JAnnotatedSample {
    public void doStuff() { System.out.println("I'm doing stuff in Javaland!"); }
}
