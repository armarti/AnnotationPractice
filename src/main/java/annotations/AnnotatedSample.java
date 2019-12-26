package annotations;

@AnnotationSample(
        required = @AnnotationUsedInOtherAnnotation(id=3, name="nom"),
        req = "req'd field"
)
public class AnnotatedSample {
    public void doStuff() {
        System.out.println("I'm doing stuff.");
    }
}
