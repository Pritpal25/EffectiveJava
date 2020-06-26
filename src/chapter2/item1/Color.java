package chapter2.item1;

/*Item 1 demostrates how using static methods for contructors can provide 3 advantages
* a) These methods have names as opposed to contructors
* b) They can have in built logic to return the same type at every invocation.
* c) They can also return the subtype, as opposed to the contructors.
* */

public class Color {
    private String color = "Red";

    // Example for constructors with names
    public static Color getDefaultColor() {
        // some logic
        return new Color();
    }

    // Example for no new object creation required
    public static Color getInstance() {
        // return the same color object at every invocation based on certain logic.
        // returning null here to avoid having that logic.
        return null;
    }

    public static Color getColorSubtype() {
        return new PrimaryColor();
    }

    public static void main(String[] args) {
        Color testColor = getDefaultColor();
        System.out.println(testColor.color);

        /*testColor = getInstance();
        System.out.println(testColor.color);*/

        testColor = getColorSubtype();
        System.out.println(testColor.getClass());
    }
}
