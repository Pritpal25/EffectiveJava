package chapter3.item10;

public class PhoneNumber {
    private int areaCode;
    private int lineNum;

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
}
