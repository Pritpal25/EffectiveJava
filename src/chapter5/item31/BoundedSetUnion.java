package chapter5.item31;

import java.util.HashSet;
import java.util.Set;

public class BoundedSetUnion {
    public static <E> Set<E> union(Set<? extends E> set1, Set<? extends E> set2) {
        Set<E> result = new HashSet<>(set1);
        result.addAll(set2);

        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<Integer>() {{add(1); add(3); add(10);}};
        Set<Double> set2 = new HashSet<Double>() {{add(2.3); add(4.5);}};

        // This doesn't work if the bounded wildcard type is not added to the producers in the input parameters
        // of the union method.

        Set<Number> result = BoundedSetUnion.union(set1, set2);

        // V IMP : In this statement above, the return type of the union is contextually derived by compiler as Set<Number>
        // Earlier version of Java required a contextual declaration of the return type -
        // also known as "explicit type argument"

        Set<Number> result2 = BoundedSetUnion.<Number>union(set1, set2);
    }
}
