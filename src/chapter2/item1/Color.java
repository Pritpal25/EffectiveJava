package chapter2.item1;

public class Color {
    private String color = "Red";

    // Uncomment this to see disadvantage no 1.
    /*private Color() {

    }*/
    // Example for static factory method with names
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
