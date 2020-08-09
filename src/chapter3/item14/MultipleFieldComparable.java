package chapter3.item14;

import java.util.Comparator;

public class MultipleFieldComparable implements Comparable<MultipleFieldComparable>{
    private int areaCode;
    private int lineNum;

    // Adding this to demonstrate how to do lazy loading of hashCode and cache the same to avoid computing everytime
    // its needed. This isn't required for this class but usually for expensive to compute or immutable classes.
    private int hashCode; // Initialized to 0 by default.

    public MultipleFieldComparable(int areaCode, int lineNum) {
        this.areaCode = areaCode;
        this.lineNum = lineNum;
    }

    // Used object in the method argument and had override annotation.
    @Override
    public boolean equals(Object obj) {
        // Compared reference to this.
        if(this == obj) {
            return true;
        }

        // Check against proper type.
        if(!(obj instanceof MultipleFieldComparable)) {
            return false;
        }

        // Typecast to proper type.
        MultipleFieldComparable pn = (MultipleFieldComparable)obj;

        // Checked all the significant fields.
        return pn.lineNum == lineNum && pn.areaCode == areaCode;
    }

    @Override public int hashCode() {
        int result = hashCode;

        if (result == 0) {
            result = Integer.hashCode(areaCode);
            result = 31 * result + Integer.hashCode(lineNum);
            hashCode = result;
        }

        return result;
    }

    // This is how you construct a static comparator. Check out Comparator class to know more about how different kinds
    // of comparators can be constructed using comparing and thenComparating methods.
/*    private static final Comparator<MultipleFieldComparable> COMPARATOR =
            Comparator.comparingInt((MultipleFieldComparable pn) -> pn.areaCode)
            .thenComparingInt(pn -> pn.lineNum);*/

    @Override
    public int compareTo(MultipleFieldComparable o) {
        // Avoid using <,> in the compareTo methods,
        // Use the Boxed class's static compare methods instead.

        int result = Integer.compare(areaCode, o.areaCode);

        if (result == 0) {
            result = Integer.compare(lineNum, o.lineNum);
        }
        return result;

        // Use the below statement if you want to use the static comparator above.
        // Does the exact same job as the comparator in this method, has a slight performance hit.
        // return COMPARATOR.compare(this, o);
    }

    public static void main(String[] args) {
        MultipleFieldComparable pn1 = new MultipleFieldComparable(123, 456);
        MultipleFieldComparable pn2 = new MultipleFieldComparable(123, 456);
        MultipleFieldComparable pn3 = new MultipleFieldComparable(123, 457);

        System.out.println(pn1.equals(pn2));
        System.out.println(pn1.compareTo(pn2));
        System.out.println(pn2.equals(pn3));
        System.out.println(pn2.compareTo(pn3));
        System.out.println(pn3.equals(pn1));
        System.out.println(pn3.compareTo(pn1));
    }
}
