package com.armarti.annotationspractice;

import com.armarti.annotationspractice.annotations.JAnnotatedSample;

public class Main {

    public static void main(String[] args) {

        System.out.println("JAnnotationReader.readAnnotations(JAnnotatedSample.class):");
        JAnnotationReader.readAnnotations(JAnnotatedSample.class);

        JAnnotatedSample as = new JAnnotatedSample();
        as.doStuff();

    }

}
