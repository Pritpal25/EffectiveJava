package chapter4.item23.taggedClass;

public class Figure {
    enum Shape {CIRCLE, RECTANGLE};

    final Shape tag;

    double radius;

    double length;
    double breadth;

    Figure(double radius) {
        tag = Shape.CIRCLE;
        this.radius = radius;
    }

    Figure(double length, double breadth) {
        tag = Shape.RECTANGLE;
        this.length = length;
        this.breadth = breadth;
    }

    double area() {
        switch (tag) {
            case CIRCLE:
                return radius*radius*Math.PI;
            case RECTANGLE:
                return length*breadth;
            default:
                throw new AssertionError(tag);
        }
    }

    public static void main(String[] args) {
        Figure circle = new Figure(23.2);

        // Generic Figure class, instead of specific implementation class name.
        // In class hierarchy design, you know about the class type from the class name.
        System.out.println(circle.getClass());
    }
}
