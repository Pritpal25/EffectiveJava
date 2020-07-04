package chapter3.item10;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// Example demonstrating this getClass in Point class::equals method doesnt work.

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

        // This should return true but its returning false
        // Investigating on what's going on here.
        System.out.println(sampleSet.contains(ap));
    }
}
