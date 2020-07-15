package chapter5.item26;

import java.util.HashSet;
import java.util.Set;

public class UnboundedWildcardType {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        randomFunc(strings);
    }

    private static void randomFunc(Set<?> set) {
        Integer integer = new Integer(25);
        // Compile time error below - prevent addition to set because of type safety.
        //set.add(integer);
    }

/*    private static void randomFunc(Set set) {
        // Lets you add, but there is a compiler warning.
        // This will manifest into a runtime classcast exception.
        Integer integer = new Integer(25);
        set.add(integer);
    }*/
}
