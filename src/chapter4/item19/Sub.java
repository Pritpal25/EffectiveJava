package chapter4.item19;

import java.time.Instant;

public class Sub extends Super {
    private final Instant instant;

    public Sub() {
        instant = Instant.now();
    }

    @Override
    public void overrideMe() {
        System.out.println(instant);
    }

    public static void main(String[] args) {
        // Ways to observe the FINAL in 2 states, once before initialization and once after.
        // Parent constructor gets invoked before the child constructor when creating an instance of child class.
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
