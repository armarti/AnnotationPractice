Taken completely from [here](http://tutorials.jenkov.com/java-reflection/annotations.html).

# Java Reflection - Annotations

- [What are Java Annotations?](#1)
- [Class Annotations](#2)
- [Method Annotations](#3)
- [Parameter Annotations](#4)
- [Field Annotations](#5)

> Jakob Jenkov<br>
> Last update: 2014-05-21
 
Using Java Reflection you can access the annotations attached to Java classes at runtime.

<h2 id="1">What are Java Annotations?</h2>

Annotations is a new feature from Java 5. Annotations are a kind of comment or meta data you can insert in your Java 
code. These annotations can then be processed at compile time by pre-compiler tools, or at runtime via Java Reflection. 
Here is an example of class annotation:

```java
@MyAnnotation(name="someName",  value = "Hello World")
public class TheClass {
}
```

The class TheClass has the annotation `@MyAnnotation` written ontop. Annotations are defined like interfaces. Here is the 
MyAnnotation definition:

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface MyAnnotation {
    public String name();
    public String value();
}
```

The `@` in front of the interface marks it as an annotation. Once you have defined the annotation you can use it in your 
code, as shown in the earlier examples.

The two directives in the annotation definition, `@Retention(RetentionPolicy.RUNTIME)` and `@Target(ElementType.TYPE)`, 
specifies how the annotation is to be used.

`@Retention(RetentionPolicy.RUNTIME)` means that the annotation can be accessed via reflection at runtime. If you do not 
set this directive, the annotation will not be preserved at runtime, and thus not available via reflection.

`@Target(ElementType.TYPE)` means that the annotation can only be used ontop of types (classes and interfaces typically). 
You can also specify METHOD or FIELD, or you can leave the target out alltogether so the annotation can be used for both 
classes, methods and fields.

Java annotations are explained in more detail in my Java Annotations tutorial.

<h2 id="2">Class Annotations</h2>

You can access the annotations of a class, method or field at runtime. Here is an example that accesses the class 
annotations:

```java
Class aClass = TheClass.class;
Annotation[] annotations = aClass.getAnnotations();

for(Annotation annotation : annotations){
    if(annotation instanceof MyAnnotation){
        MyAnnotation myAnnotation = (MyAnnotation) annotation;
        System.out.println("name: " + myAnnotation.name());
        System.out.println("value: " + myAnnotation.value());
    }
}
```

You can also access a specific class annotation like this:

```java
Class aClass = TheClass.class;
Annotation annotation = aClass.getAnnotation(MyAnnotation.class);

if(annotation instanceof MyAnnotation){
    MyAnnotation myAnnotation = (MyAnnotation) annotation;
    System.out.println("name: " + myAnnotation.name());
    System.out.println("value: " + myAnnotation.value());
}
```

<h2 id="3">Method Annotations<h2>

Here is an example of a method with annotations:

```java
public class TheClass {
  @MyAnnotation(name="someName",  value = "Hello World")
  public void doSomething(){}
}
```

You can access method annotations like this:

```java
Method method = ... //obtain method object
Annotation[] annotations = method.getDeclaredAnnotations();

for(Annotation annotation : annotations){
    if(annotation instanceof MyAnnotation){
        MyAnnotation myAnnotation = (MyAnnotation) annotation;
        System.out.println("name: " + myAnnotation.name());
        System.out.println("value: " + myAnnotation.value());
    }
}
```

You can also access a specific method annotation like this:

```java
Method method = ... // obtain method object
Annotation annotation = method.getAnnotation(MyAnnotation.class);

if(annotation instanceof MyAnnotation){
    MyAnnotation myAnnotation = (MyAnnotation) annotation;
    System.out.println("name: " + myAnnotation.name());
    System.out.println("value: " + myAnnotation.value());
}
```

<h2 id="4">Parameter Annotations<h2>

It is possible to add annotations to method parameter declarations too. Here is how that looks:

```java
public class TheClass {
  public static void doSomethingElse(
        @MyAnnotation(name="aName", value="aValue") String parameter){
  }
}
```

You can access parameter annotations from the Method object like this:

```java
Method method = ... //obtain method object
Annotation[][] parameterAnnotations = method.getParameterAnnotations();
Class[] parameterTypes = method.getParameterTypes();

int i=0;
for(Annotation[] annotations : parameterAnnotations){
  Class parameterType = parameterTypes[i++];

  for(Annotation annotation : annotations){
    if(annotation instanceof MyAnnotation){
        MyAnnotation myAnnotation = (MyAnnotation) annotation;
        System.out.println("param: " + parameterType.getName());
        System.out.println("name : " + myAnnotation.name());
        System.out.println("value: " + myAnnotation.value());
    }
  }
}
```

Notice how the `Method.getParameterAnnotations()` method returns a two-dimensional Annotation array, containing an array 
of annotations for each method parameter.

<h2 id="5">Field Annotations</h2>

Here is an example of a field with annotations:

```java
public class TheClass {

  @MyAnnotation(name="someName",  value = "Hello World")
  public String myField = null;
}
```

You can access field annotations like this:

```java
Field field = ... //obtain field object
Annotation[] annotations = field.getDeclaredAnnotations();

for(Annotation annotation : annotations){
    if(annotation instanceof MyAnnotation){
        MyAnnotation myAnnotation = (MyAnnotation) annotation;
        System.out.println("name: " + myAnnotation.name());
        System.out.println("value: " + myAnnotation.value());
    }
}
```

You can also access a specific field annotation like this:

```java
Field field = ... // obtain method object
Annotation annotation = field.getAnnotation(MyAnnotation.class);

if(annotation instanceof MyAnnotation){
    MyAnnotation myAnnotation = (MyAnnotation) annotation;
    System.out.println("name: " + myAnnotation.name());
    System.out.println("value: " + myAnnotation.value());
}
```