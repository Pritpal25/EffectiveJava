package chapter3.item10;

public class ColorPoint extends Point {
    private Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ColorPoint)){
            return false;
        }

        ColorPoint cp = (ColorPoint)obj;
        return super.equals(obj) && (cp.color == color);
    }

    // COLOR BLINDNESS

    /*@Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Point)) {
            return false;
        }

        // If obj is Point,then run a color blind comparison, by invoking the parent equals method.
        if(!(obj instanceof ColorPoint)) {
            return obj.equals(this);
            // its the same as return super(obj);
        }

        ColorPoint cp = (ColorPoint)obj;
        return super.equals(obj) && (cp.color == color);
    }*/

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.BLUE);

        // Symmetry fails - since the parent class completely ignores the color and child class fails on type check
        System.out.println(p.equals(cp));
        System.out.println(cp.equals(p));

        // Add color blindness to the equals method and then run below.
       /* ColorPoint cp1 = new ColorPoint(1, 2, Color.BLUE);
        Point p1 = new Point(1, 2);
        ColorPoint cp2 = new ColorPoint(1, 2, Color.RED);

        System.out.println(cp1.equals(p1));
        System.out.println(p1.equals(cp2));
        System.out.println(cp1.equals(cp2));*/
    }
}
