package chapter5.item28;

import java.util.ArrayList;
import java.util.List;

public class CovariantInvariantExample {
    public static void main(String[] args) {
        // ARRAYS ARE COVARIANT
        Object[] objects = new Long[1];
        // ARRAYS ARE REIFIED - ENFORCE TYPE ON RUNTIME
        objects[0] = "I am allowed at compile time";

        // This statement below doesn't even compile because
        // GENERICS ARE INVARIANT AND IMPLEMENTED USING ERASURE - ENFORCE TYPE AT COMPILE TIME
        //List<Object> ol = new ArrayList<Long>();
    }
}
