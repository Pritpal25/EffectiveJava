package chapter5.item30;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class RecursiveTypeBound {
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c == null) {
            throw new IllegalArgumentException();
        }

        E result = null;

        for(E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 10, 5, 9, 2);

        System.out.println(max(list));
    }
}
