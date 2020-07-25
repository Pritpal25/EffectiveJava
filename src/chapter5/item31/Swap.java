package chapter5.item31;

import java.util.Arrays;
import java.util.List;

public class Swap {
    public static <E> void swap1(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }
/*
    // Uncomment this to see that there is a compiler error in trying to input the value in this list
    // within this method. The reason is because the type of list is List<?> and you can't put any value except null
    // into a List<?>
    public static void swap1(List<?> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }*/

    public static void swap2(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 2, 5, 7, 4);

        swap1(list, 2, 4);
        System.out.println(list);

        swap2(list, 1, 3);
        System.out.println(list);
    }
}
