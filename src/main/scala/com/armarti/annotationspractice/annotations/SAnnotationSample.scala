package com.armarti.annotationspractice.annotations

import scala.annotation.ClassfileAnnotation

class SAnnotationSample(
  required: SAnnotationUsedInOtherAnnotation,
  optional1: SAnnotationUsedInOtherAnnotation =
    new SAnnotationUsedInOtherAnnotation(
        id = 1, 
        name = "Name1"
    ),
  optional2: SAnnotationUsedInOtherAnnotation =
    new SAnnotationUsedInOtherAnnotation(
        id = 1, 
        name = "Name2", 
        description = "desc-ription"
    ),
  req: String,
  opt: String = "hehhe hoohoo"
) extends ClassfileAnnotation
