package chapter4.item23.classHierarcy;

public class Circle extends Figure{
    final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override double area() {
        return radius*radius*Math.PI;
    }
}
