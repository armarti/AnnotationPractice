package com.armarti.annotationspractice

import scala.annotation.{Annotation, StaticAnnotation}
import com.armarti.annotationspractice.annotations.{SAnnotationSample, SAnnotationUsedInOtherAnnotation}
import scala.reflect.runtime._
import scala.reflect.runtime.universe._

object X {

  // http://www.scala-archive.org/How-to-get-annotation-with-default-value-in-scala-td4647506.html
  def getClassAnnotation[A: TypeTag] (beanClazz: Class[_] ): A = {
    val typeAnnotation = currentMirror.typeOf[A]
    currentMirror.classSymbol (beanClazz).toType.typeSymbol.asClass.annotations.find (a => a.tree.tpe == typeAnnotation).map {
      annotation =>
        val value = annotation.tree.children.tail.map (
          _.productElement (0).asInstanceOf[Constant].value
        )
        currentMirror.reflectClass(typeAnnotation.typeSymbol.asClass)
          .reflectConstructor(
            typeAnnotation.decl(termNames.CONSTRUCTOR).asMethod
          )(value: _*)
    }.get.asInstanceOf[A]
  }

  def getValue(tree: Tree) = tree match {
    case select @ Select(_, _) =>
      import scala.tools.reflect.ToolBox
      val tb = currentMirror.mkToolBox()
      tb.eval(tb.untypecheck(select))
    case Literal(Constant(value)) => value
  }

}
