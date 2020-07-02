package chapter3.item10;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point))
            return false;

        Point p = (Point)obj;
        return (x == p.x) && (y ==p.y);
    }

    // Use this for demonstration with AtomicPoint class.
    /*@Override
    public boolean equals(Object obj) {
        if(obj == null  || (obj.getClass() != getClass())) {
            return false;
        }

        Point p = (Point)obj;

        return p.x == x && p.y == y;
    }*/
}
