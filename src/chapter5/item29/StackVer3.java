package chapter5.item29;

import java.util.Arrays;

public class StackVer3<E> {
    private Object[] objects;

    private int curr_size = 0;
    private static final int DEFAULT_CAPACITY = 2;

    public StackVer3() {
        // Generates a compiler error of Generic Array Creation.
        //objects = new E[DEFAULT_CAPACITY];

        // We fix that by changing the type of the array from E to Object.
        objects = new Object[DEFAULT_CAPACITY];
    }

    public E pop() {
        if(curr_size == 0)
            return null;

        // We will have unchecked cast warning every-ime we try to read the element from this array.
        // Which can be suppressed since we know its a typesafe cast - same reasons as StackVer2

        // Push requires the type to be E, so this cast is always correct.
        @SuppressWarnings("unchecked") E toReturn = (E)objects[--curr_size];
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
        StackVer3<Integer> stack = new StackVer3<>();
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
    }
}
