package chapter5.item30;

import java.util.HashSet;
import java.util.Set;

public class SetUnion {
    public static Set union1(Set set1, Set set2) {
        Set result = new HashSet(set1);

        result.addAll(set2);
        return result;
    }

    public static <E> Set<E> union2(Set<E> set1, Set<E> set2) {
        Set<E> result = new HashSet<>(set1);

        result.addAll(set2);
        return result;
    }
     public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<Integer>() {{add(1); add(10); add(5);}};
        Set<Integer> set2 = new HashSet<Integer>() {{add(3); add(10); add(6);}};

        Set<String> set3 = new HashSet<String>() {{add("Kaku"); add("Deepa"); add("Gagan");}};
        Set<String> set4 = new HashSet<String>() {{add("Harpreet"); add("Kaku"); add("Maneet");}};

        Set result = union1(set1, set3);
        System.out.println(result);

        // Guaranteed type safety at compile time.
        //result = union2(set1, set3);

         result = union2(set3, set4);

         System.out.println(result);
     }
}
