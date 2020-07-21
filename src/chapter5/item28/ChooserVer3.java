package chapter5.item28;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserVer3<T> {
    private final List<T> choiceList;

    public ChooserVer3(Collection<T> collection) {
        choiceList = new ArrayList<>(collection);
    }

    public T randomObj(){
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        ChooserVer3<Integer> chooser = new ChooserVer3(myList);
        Integer resultInteger = chooser.randomObj();  // compiles well, runs well
        //String resultString = chooser.randomObj(); // doesnt compile
    }}
