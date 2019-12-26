package com.armarti.annotationspractice.annotations

import scala.annotation.StaticAnnotation

class SAnnotationUsedInOtherAnnotation(
  id: Int,
  name: String,
  description: String = "default description"
) extends StaticAnnotation
