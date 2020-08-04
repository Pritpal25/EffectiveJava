package chapter2.item4;

public class UtilityClass {

    // This constructor is deliberately made private to suppress any instance being created
    // from outside the class.
    private UtilityClass() {
        // This exception is thrown to ensure that during incorrect invocation of the constructor
        // from within the class as well, there is no instance generation.
        throw new AssertionError();
    };
}

/*
A few times when we need Non - Instantiable classes
a) For grouping of static fields and static methods
-- Like java.lang.math : https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html
-- Grouping static factory methods
-- Grouping methods on final classes, since they cant be put in subclass. ??

If you don't write a constructor in class, compiler provider a public one by default. So one must provide a private
one with assertion error to avoid instantiability.

Also, keeping the class abstract wont work, since one can always subclass and then instantiate.
 */