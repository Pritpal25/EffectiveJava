package chapter4.item23.classHierarcy;

public class Rectangle extends Figure{
    // These fields are accessed directly which is a bad design if the hierarchy was overall public.
    // Done for brevity here, otherwise use accessor methods for proper design.
    final double length;
    final double breadth;

    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override double area() {
        return length*breadth;
    }
}
