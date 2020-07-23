package chapter5.item31;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BoundedWildcardStack<E> {
    private E[] objects;

    private int curr_size = 0;
    private static final int DEFAULT_SIZE = 2;

    public BoundedWildcardStack() {
        objects = (E[])new Object[DEFAULT_SIZE];
    }

    public void push(E e) {
        checkCapacity();

        objects[curr_size++] = e;
    }

    public E pop() {
        if (curr_size == 0) {
            return null;
        }

        E result = objects[--curr_size];
        objects[curr_size] = null;

        return  result;
    }

    public boolean isEmpty() {
        return curr_size == 0;
    }

    // Original Implementation of pushAll, this requires the type of the parameter to exactly be Iterable<E>
    // Since generics are invariant, even a subtype of E wont be permitted in this method.
/*   public void pushAll(Iterable<E> src) {
        for(E e : src) {
            push(e);
        }
    }*/

    public void pushAll(Iterable<? extends E> src) {
        for(E e : src) {
            push(e);
        }
    }

    /*public void popAll(Collection<E> dst) {
        while(!isEmpty()) {
            dst.add(pop());
        }
    }*/

    public void popAll(Collection<? super E> dst) {
        while(!isEmpty()) {
            dst.add(pop());
        }
    }

    private void checkCapacity() {
        if(curr_size == objects.length) {
            objects = Arrays.copyOf(objects, curr_size*2 + 1);
        }
    }

    public static void main(String[] args) {
        BoundedWildcardStack<Number> stack = new BoundedWildcardStack<>();

        stack.push(2);
        stack.push(10);
        stack.push(5);
        stack.push(9);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


        List<Integer> numbers = Arrays.asList(20, 30, 40, 50);
        // Doesn't work with the original implementation of pushAll(commented out).
        // Even though stack.push(e) works where e is an Integer
        // stack.pushAll(numbers);

        stack.push(Integer.valueOf(99));
        System.out.println(stack.pop());

        // So, we update the producer method to take anything that extends the type parameter as imput for pushAll
        // method.
        stack.pushAll(numbers);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        Collection<Object> collection = null;

        // Doesn't work with original implementation of popAll(commented) since generics are invariant.
        // Even though, once popped the element can be assinged to an Object, since Number is an Object.
        // So, we need to change the declaration to use wildcard type such that a collection of any any super
        // type can be used an input parameter to the popAll method.

        //stack.popAll(collection);

        stack.popAll(collection);
    }
}
