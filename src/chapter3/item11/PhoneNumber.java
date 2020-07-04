package chapter3.item11;

public class PhoneNumber {
    private int areaCode;
    private int lineNum;

    // Adding this to demonstrate how to do lazy loading of hashCode and cache the same to avoid computing everytime
    // its needed. This isnt required for this class in general but usually for expensive to cpmpute immutable classes.
    private int hashCode; // Initialized to 0 by default.

    public PhoneNumber(int areaCode, int lineNum) {
        this.areaCode = areaCode;
        this.lineNum = lineNum;
    }

    // Used object in the method argument and had override annotation.
    @Override
    public boolean equals(Object obj) {
        // Copared reference to this.
        if(this == obj) {
            return true;
        }

        // Check against proper type.
        if(!(obj instanceof PhoneNumber)) {
            return false;
        }

        // Typecast to proper type.
        PhoneNumber pn = (PhoneNumber)obj;

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
}
