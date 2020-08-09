package chapter3.item14;

import java.util.*;

public class SingleFieldComparable implements Comparable<SingleFieldComparable>{
    private String s;

    public SingleFieldComparable(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override public boolean equals(Object obj) {
        return obj instanceof SingleFieldComparable && s.equalsIgnoreCase(((SingleFieldComparable)obj).s);
    }

    @Override
    public int hashCode() {
        // Change to the below return to see duplicate values getting populated to the HashSet.

        // All the add methods add to the same bucket.
        return String.CASE_INSENSITIVE_ORDER.hashCode();

        // Forces the add method to go to a bucket provided by a case sensitive hash value.
        // return s.hashCode();
    }

    @Override
    public String toString() {
        return s;
    }

    @Override
    public int compareTo(SingleFieldComparable o) {
        return String.CASE_INSENSITIVE_ORDER.compare(s, o.s);
    }

    public static void main(String[] args) {
        // args to contain : maneet kaku deepa gagan Kaku Maneet Deepa Gagan kaku

        SingleFieldComparable cis = new SingleFieldComparable("polish");
        SingleFieldComparable cis2 = new SingleFieldComparable("Polish");

        // In this example, equals and compareTo contract are consistent with each other.
        System.out.println(cis.equals(cis2));
        System.out.println(cis.compareTo(cis2));

        // In the example below, TreeSet and HashSet work as expected, because equals, hashCode and compareTo method
        // are consistent with each other. See the implementation of hashCode and do that experiment to see what happens.

        Set<SingleFieldComparable> treeSet = new TreeSet<>();
        for(String arg : args) {
            treeSet.add(new SingleFieldComparable(arg));
        }
        // Prints a sorted collection
        System.out.println(treeSet);

        Set<SingleFieldComparable> hashSet = new HashSet<>();
        for(String arg : args) {
            hashSet.add(new SingleFieldComparable(arg));
        }
        // Prints a unique collection in the order its inserted.
        System.out.println(hashSet);
    }
}
