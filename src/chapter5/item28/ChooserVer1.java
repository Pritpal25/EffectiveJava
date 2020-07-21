package chapter5.item28;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserVer1 {
    private final Object[] choice;

    public ChooserVer1(Collection collection) {
        choice = collection.toArray();
    }

    public Object randomObj() {
        Random rnd = ThreadLocalRandom.current();
        return choice[rnd.nextInt(choice.length)];
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(5, 10, 15);
        ChooserVer1 chooser = new ChooserVer1(intList);

        // Casts required
        Integer i = (Integer) chooser.randomObj();
        // Fails at runtime. No type safety
        String s = (String) chooser.randomObj();
    }
}
