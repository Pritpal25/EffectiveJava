package chapter5.item26;

import java.util.ArrayList;
import java.util.List;

public class GenericSubTyping {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(10));
        String s = strings.get(0);
    }

    private static void unsafeAdd(List list, Object object) {
        // Compiler giving an unchecked add warning here
        // Ignore and run, will get a ClassCastException at runtime.
        list.add(object);
    }

    // With this method, the program doesnt even compile.
    // List<String> is not a subtype of List<Object>...that's why we should always use
    // parameterized types to catch issues at compile time rather than runtime as above.
/*    private static void unsafeAdd(List<Object> list, Object object) {
        list.add(object);
    }*/
}
