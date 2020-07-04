package chapter3.item10;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// Example demonstrating how using getClass in Point::equals method doesn't work.

public class AtomicPoint extends Point{
    private static final AtomicInteger counter = new AtomicInteger();

    public AtomicPoint(int x, int y) {
        super(x, y);
        counter.incrementAndGet();
    }

    public static int getCounter() {
        return counter.get();
    }

    private static Set<Point> sampleSet = new HashSet<>();

    public static void main(String[] args) {
        sampleSet.add(new Point(1,2));
        sampleSet.add(new Point(1,3));
        sampleSet.add(new Point(1,4));

        AtomicPoint ap = new AtomicPoint(1,3);

        // This was originally returning false since the Point class did not have a HashCode overridden method.
        // Works fine now with the correctly implemented equals method. if the equals method has getClass in it for
        // typeCheck, this still returns false.
        System.out.println(sampleSet.contains(ap));
    }
}
