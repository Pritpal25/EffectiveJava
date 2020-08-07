package chapter3.item10.composition;

import chapter3.item10.Color;
import chapter3.item10.Point;

import java.util.Objects;

public class ColorPoint {
    private Point point;
    private Color color;

    public ColorPoint(int x, int y, Color color) {
        this.point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    //Returns point view of color point.
    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ColorPoint))
            return false;

        ColorPoint cp = (ColorPoint)obj;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    public static void main(String[] args) {
        Point p = new Point(1, 2);

        // ColorPoint is no longer instanceof Point in this class.
        ColorPoint cp1 = new ColorPoint(1, 2, Color.RED);
        ColorPoint cp2 = new ColorPoint(1, 2, Color.BLUE);

        System.out.println(p.equals(cp1));
        System.out.println(cp1.equals(p));
        System.out.println(cp1.equals(cp2));
    }
}
