package chapter5.item29;

import java.util.Arrays;

public class StackVer2<E> {
    private E[] objects;

    private int curr_size = 0;
    private static final int DEFAULT_CAPACITY = 2;

    // The objects are always of type E since push always allows only type E in it.
    // This ensures typeSafety, hence its okay to add SuppressWarning here.
    // However, the runtime type of the objects will always be Object[] and NOT E[]
    // This is known as heap pollution.
    @SuppressWarnings("unchecked")
    public StackVer2() {
        // Generates a compiler error of Generic Array Creation.
        //objects = new E[DEFAULT_CAPACITY];

        // Generates a warning of unchecked cast and that compiler cant be sure of type safety.
        // But we are sure since objects is a private field and only types E are every inserted into it.
        // So, we add SuppressWarning to it.
        objects = (E[])new Object[DEFAULT_CAPACITY];
    }

    public E pop() {
        if(curr_size == 0)
            return null;

        E toReturn = objects[--curr_size];
        objects[curr_size] = null;

        return toReturn;
    }

    public void push(E e) {
        checkSize();
        objects[curr_size++] = e;
    }

    private void checkSize() {
        if(curr_size == objects.length) {
            objects = Arrays.copyOf(objects, curr_size*2 + 1);
        }
    }

    public static void main(String[] args) {
        StackVer2<Integer> stack = new StackVer2<>();
        //System.out.println(stack.objects.getClass());

        stack.push(10);
        stack.push(5);
        stack.push(2);
        System.out.println(stack.pop().getClass());
        stack.push(8);
        stack.push(1);
        stack.push(9);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
