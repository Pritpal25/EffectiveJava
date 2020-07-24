package chapter5.item31;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GenericMax {
    /*public static <T extends Comparable<T>> T max(List<T> list) {
        T result = null;

        for(T t : list) {
            if (result == null || t.compareTo(result) > 0) {
                result = Objects.requireNonNull(t);
            }
        }
        return result;
    }*/

    // See the EXPLANATION IN THE BOOK FOR THIS.
    // comparable consumes the T parameter - hence super.
    // list parameter is producer - hence extends
    public static <T extends Comparable<? super T>> T max(List<? extends T> list) {
        T result = null;

        for(T t : list) {
            if (result == null || t.compareTo(result) > 0) {
                result = Objects.requireNonNull(t);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 1, 5, 4, 7, 8);
        System.out.println(max(list));
    }
}
