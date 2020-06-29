package chapter2.item7;

import java.util.Arrays;

public class Stack {
    private Object[] elements;
    int curr_index = 0;
    private static int DEFAULT_SIZE = 16;

    public Stack() {
        elements = new Object[DEFAULT_SIZE];
    }

    public void push(Object element) {
        ensureCapacity();
        elements[curr_index++] = element;
    }

    public Object pop() {
        // Because we increment every time we add an element, that means there wont be an element at whatever the
        // current index is. If the current index is 0, then there is no element in stack.
        if(curr_index == 0) {
            throw new IllegalStateException();
        }

        return elements[--curr_index];
        /* corrected version should have a below statements, since this program is managing the memory by itself.
        Object returnObj = elements[--curr_index];
        elements[curr_index] = null;
        return returnObj;*/
    }

    private void ensureCapacity() {
        if (curr_index == elements.length) {
            elements = Arrays.copyOf(elements, 2*curr_index + 1);
        }
    }
}
