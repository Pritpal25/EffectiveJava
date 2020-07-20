package chapter5.item28;

import java.util.ArrayList;
import java.util.List;

public class CovariantInvariantExample {
    public static void main(String[] args) {
        // ARRAYS ARE COVARIANT
        Object[] objects = new Long[1];
        objects[0] = "I am allowed at compile time";

        // This statement below doesn't even compile because
        // GENERICS ARE INVARIANT
        //List<Object> ol = new ArrayList<Long>();
    }
}
