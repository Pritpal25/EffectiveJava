package chapter5.item28;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserVer2<T> {
    private final T[] choice;

    @SuppressWarnings("uncheckedCast")
    public ChooserVer2(Collection<T> collection) {
        choice = (T[])collection.toArray();
    }

    public T randomObj() {
        Random rnd = ThreadLocalRandom.current();
        return choice[rnd.nextInt(choice.length)];
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(5, 10, 15);
        ChooserVer2<Integer> chooser = new ChooserVer2(intList);

        // See https://stackoverflow.com/questions/63018059/java-generics-cast-required-compile-time-error
        Integer i = chooser.randomObj(); // Compiles fine, runs fine

        // Fails at compile time.
        //String s = chooser.randomObj();
    }
}
