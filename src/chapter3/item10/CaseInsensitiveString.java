package chapter3.item10;

import java.util.Objects;

public class CaseInsensitiveString {
    private String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override public boolean equals(Object obj) {
        if (obj instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(((CaseInsensitiveString)obj).s);
        }
        // By providing this equals method with the knowledge of String class, we have introduced a one way
        // interoperability. The String class doesn't know about this class, so the equality checks initiated there
        // would fail.
        if (obj instanceof String) {
            return s.equalsIgnoreCase((String)obj);
        }
        return false;
    }

    /* Correct implementation of equals
    @Override public boolean equals(Object obj) {
        return obj instanceof CaseInsensitiveString && s.equalsIgnoreCase(((CaseInsensitiveString)obj).s);
    }*/

    public static void main(String[] args) {
        String s = "Polish";
        CaseInsensitiveString cis = new CaseInsensitiveString("polish");

        // Violation of symmetry.
        System.out.println(cis.equals(s));
        System.out.println(s.equals(cis));
    }

}
