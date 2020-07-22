package chapter5.item29;

import java.util.Arrays;

public class StackVer1 {
    private Object[] objects;

    private int curr_size = 0;
    private static final int DEFAULT_CAPACITY = 2;

    public StackVer1() {
        objects = new Object[DEFAULT_CAPACITY];
    }

    public Object pop() {
        if(curr_size == 0)
            return null;

        Object toReturn = objects[--curr_size];
        objects[curr_size] = null;

        return toReturn;
    }

    public void push(Object object) {
        checkSize();
        objects[curr_size++] = object;
    }

    private void checkSize() {
        if(curr_size == objects.length) {
            objects = Arrays.copyOf(objects, curr_size*2 + 1);
        }
    }

    public static void main(String[] args) {
        StackVer1 stack = new StackVer1();

        stack.push(10);
        stack.push(5);
        stack.push(2);
        System.out.println(stack.pop());
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
