package chapter3.item14;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class WordList {
    public static void main(String[] args) {
        // TreeSet is a set that stores in a sorted fashion, but it relies on the Class whose instaces are getting
        // stored to implement ComparableInterface. String class does, so this works.
        Set<String> sortedList = new TreeSet<>();
        Collections.addAll(sortedList, args);

        System.out.println(sortedList);
    }
}
