package com.armarti.annotationspractice.annotations

@SAnnotationSample(
  required = new SAnnotationUsedInOtherAnnotation(id = 3, name = "nom"),
  req = "req'd field"
)
class SAnnotatedSample {
  def doStuff(): Unit = println("I'm doing stuff.")
}
